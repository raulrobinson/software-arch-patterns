package com.reactive.userswebflux.domain.repository;

import com.reactive.userswebflux.domain.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepositoryPort {
    Mono<User> save(User user);
    Flux<User> findAll();
    Mono<User> findById(Long id);
    Mono<Void> deleteById(Long id);
    Mono<User> update(Long id, User user);
}
