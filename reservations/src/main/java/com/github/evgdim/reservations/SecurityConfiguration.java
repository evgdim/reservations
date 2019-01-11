package com.github.evgdim.reservations;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfiguration {
	
    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
        return http
            .authorizeExchange()
            .pathMatchers("/task", "/h2-console").permitAll()
            .anyExchange().authenticated()
            .and()
            .httpBasic().and()
            .formLogin().disable()
            .csrf().disable()
            .build();
    }
    
    
   
}
