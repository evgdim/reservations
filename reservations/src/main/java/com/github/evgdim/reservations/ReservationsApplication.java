package com.github.evgdim.reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationsApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner init(ReservationRepository resRepo) {
//		return new CommandLineRunner() {
//			
//			@Override
//			public void run(String... args) throws Exception {
//				Reservation reservation = new Reservation();
//				reservation.setDescription("asd");
//				reservation.setStart(LocalDateTime.now());
//				reservation.setEnd(LocalDateTime.now().plusDays(1L));
//				resRepo.save(reservation);
//			}
//		};
//	}
}

