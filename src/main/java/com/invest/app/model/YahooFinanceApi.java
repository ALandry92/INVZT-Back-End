package com.invest.app.model;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class YahooFinanceApi {
	
	private String YahooFinanceApi; {
	String response = null;
	try {
		response = Unirest
				.get("https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-quotes?region=US&lang=en&symbols=BAC%252CKC%253DF%252C002210.KS%252CIWM%252CAMECX")
				.header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
				.header("x-rapidapi-key", "53fdc89130msh7124cf92ce20932p1b3510jsn9f8741aa73fc").asString().getBody();
	} catch (UnirestException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(response);
	}
}
	
	


