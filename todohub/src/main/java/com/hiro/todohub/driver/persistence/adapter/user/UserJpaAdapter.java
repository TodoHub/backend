package com.hiro.todohub.driver.persistence.adapter.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiro.todohub.domain.data.user.User;
import com.hiro.todohub.domain.port.persistenceport.user.UserPersistencePort;
import com.hiro.todohub.driver.mapper.user.UserMapper;
import com.hiro.todohub.driver.persistence.entity.user.UserEntity;
import com.hiro.todohub.driver.persistence.repository.user.UserRepository;

@Service
public class UserJpaAdapter implements UserPersistencePort {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        UserEntity entity = UserMapper.getInstance().dataToEntity(user);

        if (entity != null) {
            UserEntity savedUser = this.userRepository.save(entity);

            return UserMapper.getInstance().entityToData(savedUser);
        }

        return null;
    }

    @Override
    public User login(String email) {
        if(!email.isBlank()) {
            Optional<UserEntity> entity = this.userRepository.findByEmail(email);

            if(entity.isPresent()) {
                return UserMapper.getInstance().entityToData(entity.get());
            }
            
            return null;
        }

        return null;
    }
    
}