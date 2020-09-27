package com.invest.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="portfolio")
public class Portfolio {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToOne
	private Users postedBy;
	
//	@OneToMany(mappedBy = "stockPortforlio")
//	private List<StockObserver> portfolioStocks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<StockObserver> getPortfolioStocks() {
//		return portfolioStocks;
//	}
//
//	public void setPortfolioStocks(List<StockObserver> portfolioStocks) {
//		this.portfolioStocks = portfolioStocks;
//	}

	public Users getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Users postedBy) {
		this.postedBy = postedBy;
	}
	
	
	
	
}
