package com.github.evgdim.reservations.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Resource {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
}
