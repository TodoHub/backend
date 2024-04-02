package com.hiro.todohub.domain.data.dto.user;

public record LoginResponse(String accessToken, Long expiresIn) {
}