package com.github.evgdim.reservations.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.evgdim.reservations.model.Reservation;
import com.github.evgdim.reservations.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
	private final ReservationRepository reservationRepo;
	@PostMapping
	public Reservation save(@RequestBody Reservation reservation) {
		return this.reservationRepo.save(reservation);
	}
	
	@GetMapping
	public List<Reservation> get(@RequestParam String name) {
		return this.reservationRepo.findByDescriptionContainingIgnoreCaseOrderByDescriptionAsc(name);
	}
}
