package com.reactive.userswebflux.application.command;

import com.reactive.userswebflux.domain.model.User;
import com.reactive.userswebflux.domain.repository.UserRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteUserHandler {
    private static final Logger logger = LoggerFactory.getLogger(DeleteUserHandler.class);

    private final UserRepositoryPort repository;

    public DeleteUserHandler(UserRepositoryPort repository) {
        this.repository = repository;
    }

    public Mono<Void> handle(Long id) {
        // Loguea la entrada de la operación
        logger.info("Iniciando operación de eliminación para el usuario: {}", id);

        // Eliminamos el usuario y devolvemos el resultado en un Mono
        return repository.deleteById(id)
                .doOnSuccess(aVoid -> {
                    // Loguea el usuario eliminado
                    logger.info("Usuario eliminado exitosamente: {}", id);
                })
                .doOnError(error -> {
                    // Loguea el error si ocurre alguna excepción
                    logger.error("Error al eliminar el usuario: {}", error.getMessage());
                })
                .doOnTerminate(() -> {
                    // Loguea cuando la operación haya terminado (sin importar si fue exitosa o no)
                    logger.info("Terminada la operación de eliminación del usuario.");
                });
    }
}
