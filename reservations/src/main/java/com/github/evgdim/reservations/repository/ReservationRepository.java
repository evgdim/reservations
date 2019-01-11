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
				.sql("insert into RESERVATION (description) values($1)")
				.bind("$1", task.getDescription())
				.fetch().rowsUpdated();
	}
	
	public Mono<Reservation> findByDecription(String name) {
		return db.execute()
				.sql("select * from RESERVATION where description = $1")
				.bind("$1", name)
				.map((r, rm) -> new Reservation(r.get("description", String.class))).first();
	}
}
