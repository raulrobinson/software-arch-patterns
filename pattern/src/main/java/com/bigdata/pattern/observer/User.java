package com.bigdata.pattern.observer;

import io.swagger.v3.oas.annotations.media.Schema;

public class User {
    @Schema(description = "Nombre del usuario", example = "Juan Pérez")
    private String name;

    @Schema(description = "Email del usuario", example = "juan.perez@email.com")
    private String email;

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
