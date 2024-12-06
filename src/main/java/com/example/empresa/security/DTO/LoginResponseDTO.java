package com.example.empresa.security.DTO;

import com.example.empresa.applications.records.DataRecord;

public class LoginResponseDTO{
    private final DataRecord data;
    private final String accessToken;
    private final String refreshToken;

    public LoginResponseDTO(DataRecord data, TokensDTO tokens) {
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
