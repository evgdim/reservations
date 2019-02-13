package com.github.evgdim.reservations.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.evgdim.reservations.model.User;
import com.github.evgdim.reservations.model.dto.UserGetAllDto;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	//@Query(value="select id, displayName, name from User")
	Page<UserGetAllDto> findAllProjectedBy(Pageable pageable);
}
