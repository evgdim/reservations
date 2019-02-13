package com.github.evgdim.reservations.model.dto;

import lombok.Value;

@Value
public class UserGetAllDto {
	private Long id;
	private String name;
	private String displayName;
}
