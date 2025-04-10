package com.bigdata.patterns.repository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${controller.properties.base-path}/repository")
@Tag(name = "Repository Pattern", description = "User repository operations")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<User> list() {
        return userService.getAllUsers();
    }

    @PostMapping("/create-user")
    @Operation(summary = "Create a new user")
    public User create(@RequestBody UseDTO user) {
        return userService.createUser(user);
    }

    @GetMapping("/{email}")
    @Operation(summary = "Get user by email")
    @Parameter(name = "email", description = "Email of the user to retrieve", required = true, example = "john.doe@email.com")
    public Optional<User> getByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}
