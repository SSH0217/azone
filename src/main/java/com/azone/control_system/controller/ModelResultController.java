package com.azone.control_system.controller;

import com.azone.control_system.dto.ResponseDTO;
import com.azone.control_system.dto.UserInputDTO;
import com.azone.control_system.model.ModelResultEntity;
import com.azone.control_system.service.ModelResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class ModelResultController {
    @Autowired
    private ModelResultService modelResultService;

    public void testModel(int age, int height, int weight){
        List<ModelResultEntity> list = modelResultService.retrieve();
        ModelResultEntity sbp;
        ModelResultEntity dbp;
        if(list.get(0).getSbpOrDbp().equals("sbp")){
            sbp = list.get(0);
            dbp = list.get(1);
        }
        else {
            sbp = list.get(1);
            dbp = list.get(0);
        }

        double sbpPredict = age * sbp.getAge() + height * sbp.getHeight() + weight * sbp.getWeight() + sbp.getConstVal();
        double dbpPredict = age * dbp.getAge() + height * dbp.getHeight() + weight * dbp.getWeight() + dbp.getConstVal();

        double sbpPlusError = sbpPredict + sbpPredict * 0.1;
        double sbpMinusError = sbpPredict - sbpPredict * 0.1;
        double dbpPlusError = dbpPredict + dbpPredict * 0.1;
        double dbpMinusError = dbpPredict - dbpPredict * 0.1;

        // input value if문 확인 후 db 저장
        // if(sbpMinusError <= inputSBP && inputSBP <= sbpPlusError && dbpMinusError <= inputDBP && inputDBP <= dbpPlusError) {
        //      조건 만족시에만 db 저장
        //      return input;
        // }
        // else{
        //      log.info("Not Appropriate Value");
        // }

    }
}
