package com.malexj.app.enums;

import lombok.Getter;

public enum UserRole {
    ADMIN("ADMIN1"), USER("USER"), NONE("NONE");

    @Getter
    private String type;

    UserRole(String type) {
        this.type = type;
    }

    public static UserRole getRole(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.getType().equals(role)) {
                return userRole;
            }
        }
        return UserRole.NONE;
    }
}