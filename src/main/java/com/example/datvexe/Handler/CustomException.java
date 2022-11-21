package com.example.datvexe.Handler;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private String status;
    public CustomException(String status, String message) {
        super(message);
        this.status = status;
    }
}
