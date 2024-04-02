package com.hiro.todohub.domain.data.user;

import java.util.Set;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.hiro.todohub.domain.data.dto.user.LoginRequest;

public class User {
    private UUID userId;
    private String name;
    private String state;
    private String email;
    private String password;
    private String bio;
    private Set<Role> roles;

    public User(UUID userId, String name, String state, String email, String password, String bio, Set<Role> roles) {
        this.userId = userId;
        this.name = name;
        this.state = state;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.roles = roles;
    }

    public User() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.password(), this.password);
    }
}