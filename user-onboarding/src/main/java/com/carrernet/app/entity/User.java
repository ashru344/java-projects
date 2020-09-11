package com.carrernet.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "or_user", uniqueConstraints = @UniqueConstraint(columnNames = { "userName", "mobileNumber", }))
public class User implements Serializable {

	@Transient
	private static final long serialVersionUID = 5700395015111332660L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String userName;

	private String mobileNumber;

	private Date birthDate;

	private String password;

	private boolean isEnabled;

	// To-do to url encoding
	private String confirmationToken;
}
