package com.invest.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invest.app.model.Portfolio;
import com.invest.app.model.Users;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long>{

	List<Portfolio> findAllByPostedBy(Users user);
	
}
