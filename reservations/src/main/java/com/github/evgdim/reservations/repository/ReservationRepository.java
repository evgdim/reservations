package com.github.evgdim.reservations.repository;

import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.stereotype.Repository;

import com.github.evgdim.reservations.model.Reservation;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {
	private final DatabaseClient db;
	
	public Mono<Integer> save(Reservation task) {
		return db.execute()
				.sql("insert into RESERVATION (name) values($1)")
				.bind("$1", task.getName())
				.fetch().rowsUpdated();
	}
	
	public Mono<Reservation> findByName(String name) {
		return db.execute()
				.sql("select * from RESERVATION where name = $1")
				.bind("$1", name)
				.map((r, rm) -> new Reservation(r.get("name", String.class))).first();
	}
}
