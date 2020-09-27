package com.invest.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="portfolio_snapshot")
public class PortfolioSnapshot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String year;
	private String month;
	private String timestamp;
	
	@OneToOne
	private Portfolio portfolio;
	
	@OneToMany
	private List<SnapshotStock> stockSnapshots;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public List<SnapshotStock> getStockSnapshots() {
		return stockSnapshots;
	}

	public void setStockSnapshots(List<SnapshotStock> stockSnapshots) {
		this.stockSnapshots = stockSnapshots;
	}
	
	
	
	
}
