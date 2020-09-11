package com.carrernet.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrernet.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByUserName(String userName);

	public Optional<User> findByConfirmationToken(String confirmationToken);
}