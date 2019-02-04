package com.github.evgdim.reservations.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String detailedDescription;
	private LocalDateTime start;
	private LocalDateTime end;
	@ManyToOne
	private User user;
	@ManyToOne
	private Resource resource;
	
	public Reservation(String description) {
		this.description = description;
	}
	
	
}
