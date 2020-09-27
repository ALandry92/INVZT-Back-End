package com.invest.app.dto;

public class PriceData {

	private String currencySymbol;
	private Price averageDailyVolume10Day;
	private Price regularMarketChange;
	private Price regularMarketPreviousClose;
	private Price postMarketChange;
	
	
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public Price getAverageDailyVolume10Day() {
		return averageDailyVolume10Day;
	}
	public void setAverageDailyVolume10Day(Price averageDailyVolume10Day) {
		this.averageDailyVolume10Day = averageDailyVolume10Day;
	}
	public Price getRegularMarketChange() {
		return regularMarketChange;
	}
	public void setRegularMarketChange(Price regularMarketChange) {
		this.regularMarketChange = regularMarketChange;
	}
	public Price getRegularMarketPreviousClose() {
		return regularMarketPreviousClose;
	}
	public void setRegularMarketPreviousClose(Price regularMarketPreviousClose) {
		this.regularMarketPreviousClose = regularMarketPreviousClose;
	}
	public Price getPostMarketChange() {
		return postMarketChange;
	}
	public void setPostMarketChange(Price postMarketChange) {
		this.postMarketChange = postMarketChange;
	}
	
	
	
}
