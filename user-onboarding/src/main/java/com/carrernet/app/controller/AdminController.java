package com.carrernet.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrernet.app.dto.UserDto;
import com.carrernet.app.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/allRegisterdUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto>> getAllRegisteredUser() {

		List<UserDto> registeredUsers = userService.getRegisteredUsers();

		return new ResponseEntity<List<UserDto>>(registeredUsers, HttpStatus.OK);
	}

	@GetMapping(value = "/sendLink/{emailId}")
	public boolean sendLinkForRegistration(@PathVariable(value = "emailId") String emailAddres) {

		return userService.sendLink(emailAddres);
	}
}
