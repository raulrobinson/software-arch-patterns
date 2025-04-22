package com.reactive.userswebflux.application.command;

import com.reactive.userswebflux.application.dto.UserRequestDto;
import com.reactive.userswebflux.domain.model.User;
import com.reactive.userswebflux.domain.repository.UserRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateUserHandler {
    private static final Logger logger = LoggerFactory.getLogger(CreateUserHandler.class);

    private final UserRepositoryPort repository;

    public CreateUserHandler(UserRepositoryPort repository) {
        this.repository = repository;
    }

    public Mono<User> handle(UserRequestDto user) {
        // Loguea la entrada de la operación
        logger.info("Iniciando operación de guardado para el usuario: {}", user.getName());

        // Convertimos el DTO a un modelo de dominio
        User userToSave = new User();
        userToSave.setName(user.getName());
        userToSave.setEmail(user.getEmail());

        // Guardamos el usuario y devolvemos el resultado en un Mono
        return repository.save(userToSave)
                .doOnSuccess(savedUser -> {
                    // Loguea el usuario guardado
                    logger.info("Usuario guardado exitosamente: {}", savedUser.getName());
                })
                .doOnError(error -> {
                    // Loguea el error si ocurre alguna excepción
                    logger.error("Error al guardar el usuario: {}", error.getMessage());
                })
                .doOnTerminate(() -> {
                    // Loguea cuando la operación haya terminado (sin importar si fue exitosa o no)
                    logger.info("Terminada la operación de guardado del usuario.");
                });
    }
}
