package com.hiro.todohub.domain.port.persistenceport.user;

import com.hiro.todohub.domain.data.dto.user.LoginRequest;
import com.hiro.todohub.domain.data.dto.user.LoginResponse;
import com.hiro.todohub.domain.data.user.User;

public interface UserPersistencePort {
    User create(User user);

    LoginResponse login(LoginRequest loginRequest);
}