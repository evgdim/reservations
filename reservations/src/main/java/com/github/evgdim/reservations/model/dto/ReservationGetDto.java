package com.github.evgdim.reservations.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationGetDto {
	private Long id;
	private String description;
	private String detailedDescription;
	private LocalDateTime start;
	private LocalDateTime end;
}