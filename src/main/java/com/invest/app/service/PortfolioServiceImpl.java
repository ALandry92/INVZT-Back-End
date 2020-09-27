package com.invest.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invest.app.model.Portfolio;
import com.invest.app.repository.PortfolioRepository;

@Service
@Transactional
public class PortfolioServiceImpl implements PortfolioService {
	private PortfolioRepository portfolioRepository;

	@Autowired
	public PortfolioServiceImpl(PortfolioRepository portfolioRepository) {
		super();
		this.portfolioRepository = portfolioRepository;
	}

	@Override
	public Optional<Portfolio> findByName(String name) {
		return ((PortfolioServiceImpl) portfolioRepository).findByName(name);
	}

	@Override
	public List<Portfolio> findAll() {
		return portfolioRepository.findAll();
	}

	@Override
	public Optional<Portfolio> findById(Long id) {
		return null;
	}

}
