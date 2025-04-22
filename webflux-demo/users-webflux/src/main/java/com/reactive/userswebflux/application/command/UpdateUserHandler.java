package com.reactive.userswebflux.application.command;

import com.reactive.userswebflux.application.dto.UserRequestDto;
import com.reactive.userswebflux.domain.model.User;
import com.reactive.userswebflux.domain.repository.UserRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateUserHandler {
    private static final Logger logger = LoggerFactory.getLogger(UpdateUserHandler.class);

    private final UserRepositoryPort repository;

    public UpdateUserHandler(UserRepositoryPort repository) {
        this.repository = repository;
    }

    public Mono<User> handle(Long id, UserRequestDto user) {
        // Loguea la entrada de la operación
        logger.info("Iniciando operación de actualización para el usuario: {}", id);

        // Convertimos el DTO a un modelo de dominio
        User userToUpdate = new User();
        userToUpdate.setId(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());

        // Actualizamos el usuario y devolvemos el resultado en un Mono
        return repository.update(id, userToUpdate)
                .doOnSuccess(updatedUser -> {
                    // Loguea el usuario actualizado
                    logger.info("Usuario actualizado exitosamente: {}", updatedUser.getName());
                })
                .doOnError(error -> {
                    // Loguea el error si ocurre alguna excepción
                    logger.error("Error al actualizar el usuario: {}", error.getMessage());
                })
                .doOnTerminate(() -> {
                    // Loguea cuando la operación haya terminado (sin importar si fue exitosa o no)
                    logger.info("Terminada la operación de actualización del usuario.");
                });
    }
}
