package com.invest.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock_observer")
public class StockObserver {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String fullName;
	private String ticker;
	private int totalShares;
	private double price;
	
	@OneToOne
	private Users postedBy;
	
	@OneToOne
	private Portfolio stockPortforlio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Portfolio getStockPortforlio() {
		return stockPortforlio;
	}

	public void setStockPortforlio(Portfolio stockPortforlio) {
		this.stockPortforlio = stockPortforlio;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Users getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Users postedBy) {
		this.postedBy = postedBy;
	}
	
	
	
	
}
