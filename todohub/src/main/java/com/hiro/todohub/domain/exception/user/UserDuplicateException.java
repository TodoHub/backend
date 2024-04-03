package com.hiro.todohub.domain.exception.user;

import com.hiro.todohub.domain.data.user.User;

public class UserDuplicateException extends Exception {
    private User user;

    public UserDuplicateException(User user) {
        super();
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}