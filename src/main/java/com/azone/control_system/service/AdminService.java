package com.azone.control_system.service;

import com.azone.control_system.persistence.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    
}
