package com.reactive.userswebflux.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class UserWebSecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(HttpMethod.POST, "/users").permitAll()
                        .pathMatchers(HttpMethod.GET, "/users").permitAll()
                        .pathMatchers(HttpMethod.GET, "/users/**").permitAll()
                        .pathMatchers(HttpMethod.PUT, "/users/**").permitAll()
                        .pathMatchers(HttpMethod.DELETE, "/users/**").permitAll()
                        .pathMatchers(HttpMethod.PATCH, "/users/**").permitAll()
                        .pathMatchers("/**").permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
