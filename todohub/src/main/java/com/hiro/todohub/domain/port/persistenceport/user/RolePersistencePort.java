package com.hiro.todohub.domain.port.persistenceport.user;

import com.hiro.todohub.domain.data.user.Role;

public interface RolePersistencePort {
    Role findByName(String name);
}