package com.reactive.userswebflux.application.query;

import com.reactive.userswebflux.domain.model.User;
import com.reactive.userswebflux.domain.repository.UserRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllUsersHandler {
    private static final Logger logger = LoggerFactory.getLogger(GetAllUsersHandler.class);

    private final UserRepositoryPort repository;

    public GetAllUsersHandler(UserRepositoryPort repository) {
        this.repository = repository;
    }

    public Flux<User> handle() {
        // Recuperamos todos los usuarios como un Flux
        Flux<User> usersFlux = repository.findAll();

        // Logueamos el total de usuarios al finalizar el flujo
        return usersFlux
                .doOnSubscribe(subscription -> logger.info("Iniciando consulta de usuarios."))
                .doOnNext(user -> logger.info("Usuario encontrado: {}", user.getName()))  // Logueamos cada usuario
                .switchIfEmpty(Flux.defer(() -> {
                    logger.info("No se encontraron usuarios.");
                    return Flux.empty();  // Devuelve un Flux vacío si no hay usuarios
                }))
                .doOnTerminate(() -> {
                    // Ejecutamos el conteo del total de usuarios
                    usersFlux.count()
                            .doOnSuccess(count -> logger.info("Total de usuarios encontrados: {}", count))
                            .subscribe(); // Se suscribe aquí solo para contar, no interrumpe el flujo principal
                });

//        return repository.findAll()
//                .doOnSubscribe(subscription -> logger.info("Iniciando consulta de usuarios."))
//                //.doOnComplete(() -> logger.info("Consulta de usuarios terminada."))
//                //.doOnTerminate(() -> logger.info("Consulta finalizada, con o sin resultados."))
//                //.doOnNext(user -> logger.info("Usuario encontrado: {}", user.getName()))  // Logueamos cada usuario
//                .doOnNext(user -> logger.info("Total usuarios: {}", user.getId()))
//                .doOnError(error -> logger.error("Error al consultar usuarios: {}", error.getMessage()))
//                .switchIfEmpty(Flux.defer(() -> {
//                    logger.info("No se encontraron usuarios.");
//                    return Flux.empty();  // Devuelve un Flux vacío si no hay usuarios
//                }));
    }
}
