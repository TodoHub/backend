package com.hiro.todohub.driver.mapper.user;

import com.hiro.todohub.domain.data.user.Role;
import com.hiro.todohub.driver.persistence.entity.user.RoleEntity;

public class RoleMapper {
    private static RoleMapper instance;

    private RoleMapper() {
    }

    public static RoleMapper getInstance() {
        if (RoleMapper.instance == null) {
            RoleMapper.instance = new RoleMapper();
        }
        return RoleMapper.instance;
    }

    public RoleEntity dataToEntity(Role data) {
        if (data == null) {
            return null;
        }

        return new RoleEntity(data.getRoleId(), data.getRole());
    }

    public Role entityToData(RoleEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Role(entity.getRoleId(), entity.getRole());
    }
}