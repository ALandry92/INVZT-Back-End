package com.invest.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.invest.app.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
		
		Optional<Users> findByEmail(String email);
		Optional<Users> findById(Long id);
		@Query("FROM Users u WHERE u.email =?1 AND u.password = ?2")
		Optional<Users> login(String email, String password);	
	
		List<Users> findByFname(String name);
		void deleteById(Long id);
		Optional<Users> findById(String email);
		Optional<Users> findById(Optional<Users> user);

		
}

