package com.example.datvexe.payloads.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class LoginResponse {
    private String jwtToken;
    public LoginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
