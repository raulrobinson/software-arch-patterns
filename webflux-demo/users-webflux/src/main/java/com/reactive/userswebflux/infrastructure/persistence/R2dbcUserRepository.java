package com.reactive.userswebflux.infrastructure.persistence;

import com.reactive.userswebflux.domain.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface R2dbcUserRepository extends ReactiveCrudRepository<User, Long> {
}