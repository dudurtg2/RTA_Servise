package com.example.empresa.security.DTO;

public class LoginResponseDTO<T>{
    private final T data;
    private final String accessToken;
    private final String refreshToken;

    public LoginResponseDTO(T data, TokensDTO tokens) {
        this.data = data;
        this.accessToken = tokens.getAccessToken();
        this.refreshToken = tokens.getRefreshToken();
    }

    public Object getData() {
        return data;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
