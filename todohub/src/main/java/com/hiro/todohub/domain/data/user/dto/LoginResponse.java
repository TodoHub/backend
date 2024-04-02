package com.hiro.todohub.domain.data.user.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}