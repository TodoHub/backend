package com.hiro.todohub.driver.persistence.adapter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hiro.todohub.domain.data.dto.user.LoginRequest;
import com.hiro.todohub.domain.data.dto.user.LoginResponse;
import com.hiro.todohub.domain.data.user.User;
import com.hiro.todohub.domain.port.persistenceport.user.UserPersistencePort;
import com.hiro.todohub.driver.mapper.user.UserMapper;
import com.hiro.todohub.driver.persistence.entity.user.UserEntity;
import com.hiro.todohub.driver.persistence.repository.user.RoleRepository;
import com.hiro.todohub.driver.persistence.repository.user.UserRepository;

@Service
public class UserJpaAdapter implements UserPersistencePort {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
    public LoginResponse login(LoginRequest loginRequest) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
    
}