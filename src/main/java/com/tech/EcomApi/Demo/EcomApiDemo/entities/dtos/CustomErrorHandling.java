package com.tech.EcomApi.Demo.EcomApiDemo.entities.dtos;

public class CustomErrorHandling extends RuntimeException {
    public CustomErrorHandling(String message) {
        super(message);
    }
}
