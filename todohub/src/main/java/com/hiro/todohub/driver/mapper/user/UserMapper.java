package com.hiro.todohub.driver.mapper.user;

import java.util.HashSet;
import java.util.Set;

import com.hiro.todohub.domain.data.user.Role;
import com.hiro.todohub.domain.data.user.User;
import com.hiro.todohub.driver.persistence.entity.user.RoleEntity;
import com.hiro.todohub.driver.persistence.entity.user.UserEntity;

public class UserMapper {
    private static UserMapper instance;

    private UserMapper() {
    }

    public static UserMapper getInstance() {
        if (UserMapper.instance == null) {
            UserMapper.instance = new UserMapper();
        }
        return UserMapper.instance;
    }

    public UserEntity dataToEntity(User data) {
        if (data == null) {
            return null;
        }

        Set<RoleEntity> roles = new HashSet<>();

        for (Role role : data.getRoles()) {
            roles.add(RoleMapper.getInstance().dataToEntity(role));
        }

        return new UserEntity(data.getUserId(), data.getName(), data.getEmail(), data.getPassword(), data.getState(),
                data.getBio(), roles);
    }
    
    public User entityToData(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        Set<Role> roles = new HashSet<>();

        for (RoleEntity roleEntity : entity.getRoles()) {
            roles.add(RoleMapper.getInstance().entityToData(roleEntity));
        }

        return new User(entity.getUserId(), entity.getName(), entity.getState(), entity.getEmail(),
                entity.getPassword(), entity.getBio(), roles);
    }
}