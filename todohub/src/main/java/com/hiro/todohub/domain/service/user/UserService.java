package com.hiro.todohub.domain.service.user;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.hiro.todohub.domain.data.dto.user.LoginRequest;
import com.hiro.todohub.domain.data.dto.user.LoginResponse;
import com.hiro.todohub.domain.data.user.Role;
import com.hiro.todohub.domain.data.user.RoleType;
import com.hiro.todohub.domain.data.user.User;
import com.hiro.todohub.domain.exception.user.UserDuplicateException;
import com.hiro.todohub.domain.port.persistenceport.user.RolePersistencePort;
import com.hiro.todohub.domain.port.persistenceport.user.UserPersistencePort;
import com.hiro.todohub.domain.port.serviceport.UserServicePort;

import jakarta.transaction.Transactional;
public class UserService implements UserServicePort {

    private UserPersistencePort userPersistencePort;
    private RolePersistencePort rolePersistencePort;

    public UserService(UserPersistencePort userPersistencePort, RolePersistencePort rolePersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    @Transactional
    public User create(User user) throws Exception {
        try {
            Role basicRole = rolePersistencePort.findByName(RoleType.BASIC.name());
            User userFromDb = userPersistencePort.findByEmail(user.getEmail());

            if(user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
            } else if(userFromDb != null) {
                throw new UserDuplicateException(userFromDb);
            }

            user.setRoles(Set.of(basicRole));

            return this.userPersistencePort.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
    
}