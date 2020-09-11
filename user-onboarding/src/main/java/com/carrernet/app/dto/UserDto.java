package com.carrernet.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

	private static final long serialVersionUID = 5456825512577632015L;

	private String userName;

	private String mobileNumber;

	private Date birthDate;

	private String password;
}
