package com.invest.app.service;

import java.util.List;
import java.util.Optional;

import com.invest.app.model.Portfolio;

public interface PortfolioService {

	Optional<Portfolio> findById(Long id);
	Optional<Portfolio> findByName(String name);
	List<Portfolio> findAll();
}
