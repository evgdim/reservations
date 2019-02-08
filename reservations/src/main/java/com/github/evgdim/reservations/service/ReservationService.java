package com.github.evgdim.reservations.service;

import com.github.evgdim.reservations.model.Reservation;
import com.github.evgdim.reservations.model.dto.ReservationDto;

public interface ReservationService {
	public Reservation save(ReservationDto reservationDto);
}
