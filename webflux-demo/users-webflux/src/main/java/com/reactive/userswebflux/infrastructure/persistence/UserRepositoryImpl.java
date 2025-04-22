package com.reactive.userswebflux.infrastructure.persistence;

import com.reactive.userswebflux.domain.model.User;
import com.reactive.userswebflux.domain.repository.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImpl implements UserRepositoryPort {

    private final R2dbcUserRepository repository;

    @Autowired
    public UserRepositoryImpl(R2dbcUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<User> save(User user) {
        return repository.save(user);
    }

    @Override
    public Flux<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<User> update(Long id, User user) {
        return repository.findById(id)
                .flatMap(existingUser -> {
                    // Si el usuario existe, actualizamos los campos
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    // Puedes actualizar otros campos aquí

                    // Guardamos el usuario actualizado
                    return repository.save(existingUser);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("User not found"))); // Si no se encuentra el usuario, retornamos error
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }
}
