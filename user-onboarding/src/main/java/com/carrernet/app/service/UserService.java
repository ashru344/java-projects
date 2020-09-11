package com.carrernet.app.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carrernet.app.dto.UserDto;
import com.carrernet.app.entity.User;
import com.carrernet.app.exception.URLEncodeException;
import com.carrernet.app.exception.UserAlreadyRegisteredException;
import com.carrernet.app.repository.UserRepository;

@Service
public class UserService {

	private static final String REGISTRATION_URL = "http://localhost:8080/user/register";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmailService emailService;

	public UserDto registerUser(UserDto userDto) {
		User user = convertToEntity(userDto);
		user.setPassword(encodePassword(user.getPassword()));
		User savedUser = userRepository.save(user);

		String userName = savedUser.getUserName();
		emailService.sendEmail(userName, userName, "Hello " + userName
				+ ", \n \n you are registerd successfully !  \n\n Thanks and Regards \n  Carrer Team");

		return convertToDto(savedUser);
	}

	public boolean sendLink(String emailAddress) {

		Optional<User> lUser = userRepository.findByUserName(emailAddress.trim());

		if (lUser.isPresent())
			throw new UserAlreadyRegisteredException("user has already registered");

		emailService.sendEmail(emailAddress, emailAddress, encode(REGISTRATION_URL));

		return true;
	}

	public List<UserDto> getRegisteredUsers() {

		List<User> userDtos = userRepository.findAll();

		List<UserDto> users = userDtos.stream().map(user -> convertToDto(user)).collect(Collectors.toList());
		return users;
	}

	private User convertToEntity(UserDto dto) {
		return modelMapper.map(dto, User.class);
	}

	private UserDto convertToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public String encode(String url) {
		try {
			String encodeURL = URLEncoder.encode(url, "UTF-8");
			return encodeURL;
		} catch (UnsupportedEncodingException e) {

			throw new URLEncodeException("Url can't encoded");
		}
	}

	public void createVerificationToken(User user, String token) {
		// TODO Auto-generated method stub
		
	}
}