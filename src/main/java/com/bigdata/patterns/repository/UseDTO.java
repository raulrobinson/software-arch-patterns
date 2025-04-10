package com.bigdata.patterns.repository;

import io.swagger.v3.oas.annotations.media.Schema;

public class UseDTO {
    @Schema(description = "Name of the user", example = "John Doe")
    private String name;

    @Schema(description = "Email of user", example = "john.doe@email.com")
    private String email;

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
