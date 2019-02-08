package com.github.evgdim.reservations.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.github.evgdim.reservations.model.Reservation;
import com.github.evgdim.reservations.model.dto.ReservationDto;

@Mapper
public interface ReservationMapper {

    @Mappings({
        @Mapping(source = "userId", target = "user.id"),
        @Mapping(source = "resourceId", target = "resource.id")
    })
    Reservation carToCarDto(ReservationDto reservationDto);

}