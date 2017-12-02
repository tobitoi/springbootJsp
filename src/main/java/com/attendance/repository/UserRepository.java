package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.attendance.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("FROM User WHERE userName=:username")
	User findByUsername(@Param("username") String username);
}