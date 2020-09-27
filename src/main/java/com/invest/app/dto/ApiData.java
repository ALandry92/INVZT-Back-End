package com.invest.app.dto;

public class ApiData {

	private QuoteType quoteType;
	private PriceData price;
	private String symbol;
	
	public QuoteType getQuoteType() {
		return quoteType;
	}
	public void setQuoteType(QuoteType quoteType) {
		this.quoteType = quoteType;
	}
	public PriceData getPrice() {
		return price;
	}
	public void setPrice(PriceData price) {
		this.price = price;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
	
	
}
