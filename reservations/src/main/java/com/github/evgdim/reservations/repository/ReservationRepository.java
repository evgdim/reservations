package com.github.evgdim.reservations.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.evgdim.reservations.model.Reservation;


public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long>{
	
	public Reservation findByDescription(String description);
}
