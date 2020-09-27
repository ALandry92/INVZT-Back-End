package com.invest.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invest.app.model.Portfolio;
import com.invest.app.model.StockObserver;
import com.invest.app.model.Users;

public interface StockObserverRepository extends JpaRepository<StockObserver, Long> {

	List<StockObserver> findAllByPostedBy(Users user);
	

	List<StockObserver> findAllByStockPortforlio(Portfolio portfolio);
	
}
