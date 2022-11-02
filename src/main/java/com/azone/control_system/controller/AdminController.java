package com.azone.control_system.controller;

import com.azone.control_system.dto.AdminDTO;
import com.azone.control_system.dto.ResponseDTO;
import com.azone.control_system.model.AdminEntity;
import com.azone.control_system.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminDTO dto){
        AdminEntity admin = adminService.getByCredentials(dto.getLoginId(), dto.getPassword());
        try{
            final AdminDTO responseAdminDTO  = AdminDTO.builder()
                    .loginId(dto.getLoginId())
                    .password(dto.getPassword())
                    .name(dto.getName())
                    .build();
            return ResponseEntity.ok().body(responseAdminDTO);
        }catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.<AdminDTO>builder()
                    .error("Login Error")
                    .build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
