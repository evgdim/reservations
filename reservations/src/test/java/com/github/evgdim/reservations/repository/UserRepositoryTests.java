package com.github.evgdim.reservations.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.evgdim.reservations.model.User;
import com.github.evgdim.reservations.model.dto.UserGetAllDto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	@Autowired
	private TestEntityManager em;
	@Autowired
	private UserRepository userRepository;
	

	@Test
	public void search_shouldReturnEmpty() {
		User user = new User(null, "evgeni", "pass", "Evgeni Dimitrov");
		em.persistAndFlush(user);
		Page<UserGetAllDto> searchResult = this.userRepository.searchProjectedBy("asd", Pageable.unpaged());
		assertThat(searchResult.getContent()).isEmpty();
	}
	
	@Test
	public void search_shouldReturnOneUser() {
		User user = new User(null, "evgeni", "pass", "Evgeni Dimitrov");
		em.persistAndFlush(user);
		Page<UserGetAllDto> searchResult = this.userRepository.searchProjectedBy("gen", Pageable.unpaged());
		assertThat(searchResult.getContent()).hasSize(1);
	}
}
