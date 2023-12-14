package com.healthcare.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByUserName(String userName);
}
