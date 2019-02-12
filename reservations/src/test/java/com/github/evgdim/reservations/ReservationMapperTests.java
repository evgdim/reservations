package com.github.evgdim.reservations;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.evgdim.reservations.model.Reservation;
import com.github.evgdim.reservations.model.dto.ReservationDto;
import com.github.evgdim.reservations.model.mappers.ReservationMapper;
import com.github.evgdim.reservations.model.mappers.ReservationMapperImpl;

@SpringBootTest(classes = {ReservationMapperImpl.class})
@RunWith(SpringRunner.class)
public class ReservationMapperTests {
	
	@Autowired
	private ReservationMapper reservationMapper;
	@Test
	public void reservationDtoToReservation_shouldReturnNull_whenNullIsPassed() {
		assertThat(reservationMapper.reservationDtoToReservation(null)).isNull();
	}
	
	@Test
	public void reservationDtoToReservation_shouldMap() {
		LocalDateTime start = LocalDateTime.now();
		ReservationDto dto = getDto(start);
		Reservation res = reservationMapper.reservationDtoToReservation(dto);
		assertThat(res.getDescription()).isEqualTo("desc");
		assertThat(res.getStart()).isEqualTo(start);
		assertThat(res.getUser().getId()).isEqualTo(456L);
	}
	
	@Test
	public void reservationDtoToReservation_shouldMapResourceAndUserToNull_whenMissingInDto() {
		LocalDateTime start = LocalDateTime.now();
		ReservationDto dto = getDto(start);
		dto.setUserId(null);
		dto.setResourceId(null);
		Reservation res = reservationMapper.reservationDtoToReservation(dto);
		assertThat(res.getUser()).isNull();
		assertThat(res.getResource()).isNull();
	}
	
	private ReservationDto getDto(LocalDateTime start) {
		ReservationDto dto = new ReservationDto();
		dto.setDescription("desc");
		dto.setDetailedDescription("detDesc");
		dto.setStart(start);
		dto.setEnd(start.plusDays(1));
		dto.setResourceId(123L);
		dto.setUserId(456L);
		return dto;
	}
}
