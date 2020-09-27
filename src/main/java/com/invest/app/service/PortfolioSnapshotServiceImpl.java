package com.invest.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invest.app.model.PortfolioSnapshot;
import com.invest.app.repository.PortfolioSnapshotRepository;
import com.invest.app.repository.UserRepository;

@Service
@Transactional
public class PortfolioSnapshotServiceImpl implements PortfolioSnapshotService {
	private PortfolioSnapshotRepository portfolioSnapshotRepository;

	@Autowired
	public PortfolioSnapshotServiceImpl(PortfolioService portfolioService) {
		super();
		this.portfolioSnapshotRepository = portfolioSnapshotRepository;

	}

	@Override
	public Optional<PortfolioSnapshot> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PortfolioSnapshot> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
