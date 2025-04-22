package com.reactive.userswebflux.application.query;

import com.reactive.userswebflux.domain.model.User;
import com.reactive.userswebflux.domain.repository.UserRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FindUserByIdHandler {
    private static final Logger logger = LoggerFactory.getLogger(FindUserByIdHandler.class);

    private final UserRepositoryPort repository;

    public FindUserByIdHandler(UserRepositoryPort repository) {
        this.repository = repository;
    }

    public Mono<User> handle(Long id) {
        // Loguea la entrada de la operación
        logger.info("Iniciando operación de búsqueda para el usuario con ID: {}", id);

        // Busca el usuario por ID y devuelve el resultado en un Mono
        return repository.findById(id)
                .doOnSuccess(user -> {
                    if (user != null) {
                        // Loguea el usuario encontrado
                        logger.info("Usuario encontrado: {}", user.getName());
                    } else {
                        // Loguea si no se encontró el usuario
                        logger.warn("No se encontró ningún usuario con ID: {}", id);
                    }
                })
                .doOnError(error -> {
                    // Loguea el error si ocurre alguna excepción
                    logger.error("Error al buscar el usuario: {}", error.getMessage());
                })
                .doOnTerminate(() -> {
                    // Loguea cuando la operación haya terminado (sin importar si fue exitosa o no)
                    logger.info("Terminada la operación de búsqueda del usuario.");
                });
    }
}
