package com.hiro.todohub.driver.persistence.repository.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiro.todohub.driver.persistence.entity.user.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    
}