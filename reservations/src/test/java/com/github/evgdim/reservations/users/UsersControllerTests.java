package com.github.evgdim.reservations.users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.github.evgdim.reservations.controller.UserController;
import com.github.evgdim.reservations.model.User;
import com.github.evgdim.reservations.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = { UserController.class })
public class UsersControllerTests {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserRepository userRepo;
	
	@Test
	@WithMockUser(username="evgeni")
	public void positiveTest() throws Exception {
		User mockUser = new User();
		mockUser.setName("evgeni");
		when(userRepo.save(any())).thenReturn(mockUser);
		this.mvc.perform(post("/users")
				         .contentType(MediaType.APPLICATION_JSON)
                         .content("{\"name\": \"evgeni\", \"password\":\"pass\", \"displayName\":\"Evgeni Dimitrov\"}"))
						.andExpect(status().is2xxSuccessful())
						.andExpect(jsonPath("$.name", equalTo("evgeni")));
	}
}
