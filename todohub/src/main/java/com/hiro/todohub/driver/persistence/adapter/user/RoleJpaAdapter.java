package com.hiro.todohub.driver.persistence.adapter.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hiro.todohub.domain.data.user.Role;
import com.hiro.todohub.domain.port.persistenceport.user.RolePersistencePort;
import com.hiro.todohub.driver.mapper.user.RoleMapper;
import com.hiro.todohub.driver.persistence.entity.user.RoleEntity;
import com.hiro.todohub.driver.persistence.repository.user.RoleRepository;

public class RoleJpaAdapter implements RolePersistencePort {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        if(!name.isBlank()) {
            Optional<RoleEntity> entity= this.roleRepository.findByName(name);

            if(entity.isPresent()) {
                return RoleMapper.getInstance().entityToData(entity.get());
            }

            return null;
        }

        return null;
    }
    
}