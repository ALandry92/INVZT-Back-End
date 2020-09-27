package com.invest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invest.app.model.PortfolioSnapshot;

public interface PortfolioSnapshotRepository extends JpaRepository<PortfolioSnapshot, Long> {


}
