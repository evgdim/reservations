package com.github.evgdim.reservations.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.evgdim.reservations.model.User;
import com.github.evgdim.reservations.model.dto.UserGetAllDto;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	Page<UserGetAllDto> findAllProjectedBy(Pageable pageable);
	@Query(value="select new com.github.evgdim.reservations.model.dto.UserGetAllDto(u.id, u.name, u.displayName) "
			     + "from User u "
			    + "where name like %:searchterm% or displayName like %:searchterm%")
	Page<UserGetAllDto> searchProjectedBy(String searchterm, Pageable pageable);
}