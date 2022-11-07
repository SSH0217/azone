package com.azone.control_system.service;

import com.azone.control_system.model.UserInputEntity;
import com.azone.control_system.persistence.UserInputRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInputService {
    @Autowired
    private UserInputRepository repository;

    public int countHighTemperature(){
        List<UserInputEntity> users = repository.findByTemperatureGreaterThanEqual(37.3);
        return users.size();
    }
    public int countHypothermia(){
        List<UserInputEntity> users = repository.findByTemperatureLessThanEqual(35);
        return users.size();
    }
    public int countHighBloodPressure(){
        List<UserInputEntity> users = repository.findBySbpGreaterThanEqualOrDbpGreaterThanEqual(140, 90);
        return users.size();
    }
    public int countHypotension(){
        List<UserInputEntity> users = repository.findBySbpLessThanEqualOrDbpLessThanEqual(100, 60);
        return users.size();
    }
    public int countBradycardia(){
        List<UserInputEntity> users = repository.findByPulseLessThanEqual(60);
        return users.size();
    }
    public int countTachycardia(){
        List<UserInputEntity> users = repository.findByPulseGreaterThanEqual(100);
        return users.size();
    }
}
