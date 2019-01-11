package com.github.evgdim.reservations.repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.BiFunction;

import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.data.r2dbc.function.DatabaseClient.GenericExecuteSpec;
import org.springframework.stereotype.Repository;

import com.github.evgdim.reservations.model.Reservation;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {
	private final DatabaseClient db;
	private final BiFunction<Row, RowMetadata, Reservation> reservationMapper = 
			(r, rm) -> new Reservation(
							r.get("id", Long.class),
							r.get("description", String.class),
							r.get("detailed_description", String.class),
							toLocalDateTime(r, "start"),
							toLocalDateTime(r, "end"),
							null,
							null
						);

	private LocalDateTime toLocalDateTime(Row r, String field) {
		Date date = r.get(field, Date.class);
		if(date == null) return null;
		Instant instant = date.toInstant();
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	}
	
	public Mono<Integer> save(Reservation reservation) {
		GenericExecuteSpec sql = db.execute()
				.sql("insert into RESERVATION (description) "
						+ "values($1)");
		sql = sql.bind("$1", reservation.getDescription());
//		if(reservation.getDetailedDescription() != null) sql.bind("$2", reservation.getDetailedDescription()); else sql.bindNull("$2", String.class);
//		if(reservation.getStart() != null) sql.bind("$3", reservation.getStart()); else sql.bindNull("$3", LocalDateTime.class);
//		if(reservation.getEnd() != null) sql.bind("$4", reservation.getEnd()); else sql.bindNull("$4", LocalDateTime.class);
//		if(reservation.getUser() != null)  sql.bind("$5", reservation.getUser().getId()); else sql.bindNull("$5", Long.class);
//		if(reservation.getResource() != null) sql.bind("$6", reservation.getResource().getId()); else sql.bindNull("$6", Long.class);
		return sql.fetch().rowsUpdated();
	}
	
	public Mono<Reservation> findByDecription(String description) {
		return db.execute()
				.sql("select id, description, detailed_description, start, end "
						+ "from RESERVATION "
						+ "where description = $1")
				.bind("$1", description)
				.map(reservationMapper).first();
	}
}
