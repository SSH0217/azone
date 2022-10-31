package com.azone.control_system.persistence;

import com.azone.control_system.model.UserInputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInputRepository extends JpaRepository<UserInputEntity, String> {

}
