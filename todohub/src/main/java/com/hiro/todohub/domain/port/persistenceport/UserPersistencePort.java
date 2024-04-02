package com.hiro.todohub.domain.port.persistenceport;

import com.hiro.todohub.domain.data.user.User;
import com.hiro.todohub.domain.data.user.dto.LoginRequest;
import com.hiro.todohub.domain.data.user.dto.LoginResponse;

public interface UserPersistencePort {
    User create(User user);

    LoginResponse login(LoginRequest loginRequest);
}