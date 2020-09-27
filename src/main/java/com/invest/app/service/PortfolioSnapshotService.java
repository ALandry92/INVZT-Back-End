package com.invest.app.service;

import java.util.Optional;

import com.invest.app.model.PortfolioSnapshot;

public interface PortfolioSnapshotService {

	Optional<PortfolioSnapshot> findById(Long id);
	Optional<PortfolioSnapshot> findByName(String name);
}
