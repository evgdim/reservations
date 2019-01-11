package com.github.evgdim.reservations.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
	private Long id;
	private String description;
	private String detailedDescription;
	private LocalDateTime start;
	private LocalDateTime end;
	private User user;
	private Resource resource;
	
	public Reservation(String description) {
		this.description = description;
	}
	
	
}
