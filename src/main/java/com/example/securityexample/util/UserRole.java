package com.example.securityexample.util;

public enum UserRole {
    ADMIN("ADMIN"), TEACHER("TEACHER"), STUDENT("STUDENT");

    private final String type;

    UserRole(String string) {
        type = string;
    }

    @Override
    public String toString() {
        return type;
    }
}