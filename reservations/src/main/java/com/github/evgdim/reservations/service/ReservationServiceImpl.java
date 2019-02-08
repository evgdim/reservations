package com.github.evgdim.reservations.service;

import org.springframework.stereotype.Service;

import com.github.evgdim.reservations.model.Reservation;
import com.github.evgdim.reservations.model.dto.ReservationDto;
import com.github.evgdim.reservations.model.mappers.ReservationMapper;
import com.github.evgdim.reservations.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
	private final ReservationRepository reservationRepo;
	private final ReservationMapper reservationMapper;

	@Override
	public Reservation save(ReservationDto reservationDto) {
		Reservation reservation = this.reservationMapper.reservationDtoToReservation(reservationDto);
		return reservationRepo.save(reservation);
	}

}
