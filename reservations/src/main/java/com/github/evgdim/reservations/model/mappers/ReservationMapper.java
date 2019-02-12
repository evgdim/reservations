package com.github.evgdim.reservations.model.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.github.evgdim.reservations.model.Reservation;
import com.github.evgdim.reservations.model.dto.ReservationSaveDto;

@Mapper(componentModel="spring")
public interface ReservationMapper {

    @Mappings({
        @Mapping(source = "userId", target = "user.id"),
        @Mapping(source = "resourceId", target = "resource.id")
    })
    Reservation reservationDtoToReservation(ReservationSaveDto reservationDto);
    
    @AfterMapping
    default void setUserAndResourceToNullIfEmpty(ReservationSaveDto reservationDto, @MappingTarget Reservation reservation) {
    	if(reservation.getUser() != null && reservation.getUser().getId() == null) {
    		reservation.setUser(null);
    	}
    	if(reservation.getResource() != null && reservation.getResource().getId() == null) {
    		reservation.setResource(null);
    	}
    }
}