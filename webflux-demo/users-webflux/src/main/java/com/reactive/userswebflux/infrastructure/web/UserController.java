package com.reactive.userswebflux.infrastructure.web;

import com.reactive.userswebflux.application.command.CreateUserHandler;
import com.reactive.userswebflux.application.command.DeleteUserHandler;
import com.reactive.userswebflux.application.command.UpdateUserHandler;
import com.reactive.userswebflux.application.dto.UserRequestDto;
import com.reactive.userswebflux.application.query.FindUserByIdHandler;
import com.reactive.userswebflux.application.query.GetAllUsersHandler;
import com.reactive.userswebflux.domain.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Endpoints para gestionar usuarios.")
public class UserController {

    private final CreateUserHandler createUserHandler;
    private final GetAllUsersHandler getAllUsersHandler;
    private final FindUserByIdHandler findUserByIdHandler;
    private final UpdateUserHandler updateUserHandler;
    private final DeleteUserHandler deleteUserHandler;

    public UserController(CreateUserHandler createUserHandler, GetAllUsersHandler getAllUsersHandler, FindUserByIdHandler findUserByIdHandler, UpdateUserHandler updateUserHandler, DeleteUserHandler deleteUserHandler) {
        this.createUserHandler = createUserHandler;
        this.getAllUsersHandler = getAllUsersHandler;
        this.findUserByIdHandler = findUserByIdHandler;
        this.updateUserHandler = updateUserHandler;
        this.deleteUserHandler = deleteUserHandler;
    }

    @PostMapping
    @Operation(summary = "Create User", description = "Create a new user.")
    public Mono<User> create(@RequestBody UserRequestDto user) {
        return createUserHandler.handle(user);
    }

    @GetMapping
    @Operation(summary = "Get All Users", description = "Get all users.")
    public Flux<User> getAll() {
        return getAllUsersHandler.handle();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get User by ID", description = "Get a user by its ID.")
    @Parameter(name = "id", description = "User ID", required = true, example = "1")
    public Mono<User> findById(@PathVariable Long id) {
        return findUserByIdHandler.handle(id);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update User", description = "Update an existing user.")
    @Parameter(name = "id", description = "User ID", required = true, example = "1")
    public Mono<User> update(@PathVariable Long id, @RequestBody UserRequestDto user) {
        return updateUserHandler.handle(id, user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete User", description = "Delete a user by its ID.")
    @Parameter(name = "id", description = "User ID", required = true, example = "1")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return deleteUserHandler.handle(id);
    }
}
