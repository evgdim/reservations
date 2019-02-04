package com.github.evgdim.reservations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.evgdim.reservations.repository.ReservationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationRepositoryTests {
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Test
	public void contextLoads() {
		
	}
//	@Test
//	public void reservationShouldBeSaved() {
//		String name = "my-reservation";
//		LocalDateTime start = LocalDateTime.now();
//		LocalDateTime end = LocalDateTime.now().plusDays(1);
//		Reservation reservation = new Reservation(null,name,"", start, end, null, null);
//		StepVerifier.create(
//			this.reservationRepo.save(reservation)
//		)
//		.expectNext(1)
//		.expectComplete()
//		.verify();
//	}
//	
//	@Test
//	public void reservationShouldBeSavedAndFound() {
//		String name = "my-reservation";
//		LocalDateTime start = LocalDateTime.now();
//		LocalDateTime end = LocalDateTime.now().plusDays(1);
//		Reservation reservation = new Reservation(null,name,"", start, end, null, null);
//		StepVerifier.create(
//			this.reservationRepo.save(reservation)
//				.then(reservationRepo.findByDecription(name))
//		)
//		.expectNextMatches(res -> name.equals(res.getDescription()))
//		.expectComplete()
//		.verify();
//	}

}

