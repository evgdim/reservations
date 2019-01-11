package com.github.evgdim.reservations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.function.DatabaseClient;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;

@Configuration
public class DatabaseConfiguration {

	@Bean
	public H2ConnectionFactory connectionFactory() {
		return new H2ConnectionFactory(H2ConnectionConfiguration.builder().inMemory("testdb").username("sa").build());
	}
	
	@Bean
	public DatabaseClient databaseClient() {
		return DatabaseClient.create(connectionFactory());
	}
}
