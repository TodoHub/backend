package com.hiro.todohub.domain.port.persistenceport.user;

import com.hiro.todohub.domain.data.user.User;

public interface UserPersistencePort {
    User create(User user);

    User login(String email);
}