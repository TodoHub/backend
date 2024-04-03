package com.hiro.todohub.domain.port.serviceport;

import com.hiro.todohub.domain.data.dto.user.LoginRequest;
import com.hiro.todohub.domain.data.dto.user.LoginResponse;
import com.hiro.todohub.domain.data.user.User;

public interface UserServicePort {
    User create(User user) throws Exception;

    LoginResponse login(LoginRequest loginRequest);
}