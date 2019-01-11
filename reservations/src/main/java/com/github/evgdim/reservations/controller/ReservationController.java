package com.github.evgdim.reservations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.evgdim.reservations.model.Reservation;
import com.github.evgdim.reservations.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
	private final ReservationRepository reservationRepo;
	@PostMapping
	public Mono<Integer> save(@RequestBody Reservation task) {
		return this.reservationRepo.save(task);
	}
	
	@GetMapping
	public Mono<Reservation> get(@RequestParam String name) {
		return this.reservationRepo.findByName(name);
	}
}
