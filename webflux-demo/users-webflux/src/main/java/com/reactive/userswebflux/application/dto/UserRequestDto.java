package com.reactive.userswebflux.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User request DTO")
public class UserRequestDto {

    @Schema(description = "User name", example = "John Doe")
    private String name;

    @Schema(description = "User email", example = "john.doe@demo.com")
    private String email;
}
