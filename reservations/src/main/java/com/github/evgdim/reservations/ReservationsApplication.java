package com.github.evgdim.reservations;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.evgdim.reservations.model.Reservation;
import com.github.evgdim.reservations.repository.ReservationRepository;

@SpringBootApplication
public class ReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationsApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ReservationRepository resRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Reservation reservation = new Reservation();
				reservation.setDescription("asd");
				reservation.setStart(LocalDateTime.now());
				reservation.setEnd(LocalDateTime.now().plusDays(1L));
				resRepo.save(reservation);
			}
		};
	}
}

