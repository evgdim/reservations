package com.github.evgdim.reservations.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.evgdim.reservations.model.Resource;

public interface ResourceRepository extends PagingAndSortingRepository<Resource, Long>{
	@Query(value="select r "
		     + "from Resource r "
		    + "where name like %:searchterm% or description like %:searchterm%")
	Page<Resource> searchProjectedBy(String searchterm, Pageable pageable);
}
