package com.azone.control_system.persistence;

import com.azone.control_system.model.UserInputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInputRepository extends JpaRepository<UserInputEntity, String> {
    //고체온
    List<UserInputEntity> findByTemperatureGreaterThanEqual(double temperature);
    //저체온
    List<UserInputEntity> findByTemperatureLessThanEqual(double temperature);
    //고혈압
    List<UserInputEntity> findBySbpGreaterThanEqualOrDbpGreaterThanEqual(int sbp, int dbp);
    //저혈압
    List<UserInputEntity> findBySbpLessThanEqualOrDbpLessThanEqual(int sbp, int dbp);
    //서맥
    List<UserInputEntity> findByPulseLessThanEqual(int pulse);
    //빈맥
    List<UserInputEntity> findByPulseGreaterThanEqual(int pulse);
}
