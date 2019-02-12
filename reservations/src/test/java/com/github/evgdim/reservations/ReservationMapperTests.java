package com.github.evgdim.reservations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
