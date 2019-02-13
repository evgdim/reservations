package com.github.evgdim.reservations.controller;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.evgdim.reservations.model.User;
import com.github.evgdim.reservations.model.dto.UserGetAllDto;
import com.github.evgdim.reservations.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserRepository userRepository;
	@GetMapping("/authenticated")
	public Principal getUser(@AuthenticationPrincipal Principal principal) {
		return principal;
	}
	
	@GetMapping
	public Page<UserGetAllDto> getUsers(@RequestParam int page, @RequestParam int size) {
		return this.userRepository.findAllProjectedBy(PageRequest.of(page, size));
	}
	
	@PostMapping
	public User postUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
}
