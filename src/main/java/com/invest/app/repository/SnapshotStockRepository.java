package com.invest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invest.app.model.SnapshotStock;

public interface SnapshotStockRepository extends JpaRepository<SnapshotStock, Long>{

}
