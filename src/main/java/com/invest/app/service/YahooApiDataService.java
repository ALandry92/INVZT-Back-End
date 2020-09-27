package com.invest.app.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.invest.app.dto.ApiData;

@Service
public class YahooApiDataService {
	
	private final String API_URL = "https://apidojo-yahoo-finance-v1.p.rapidapi.com";
	private final String REGION_DATA = "region=US&lang=en&symbols=BAC%252CKC%253DF%252C002210.KS%252CIWM%252CAMECX";
	private final String HOST ="apidojo-yahoo-finance-v1.p.rapidapi.com";
	private final String API_KEY = "53fdc89130msh7124cf92ce20932p1b3510jsn9f8741aa73fc";
	
	private RestTemplate restTemplate;
	
	@Autowired
	public YahooApiDataService(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	@Retryable(
		      value = { Exception.class }, 
		      maxAttempts = 2,
		      backoff =  @Backoff(delay=5000))
	public ApiData getStockData(String ticker) {
		ResponseEntity<ApiData> searchResults = restTemplate
				.exchange(
						API_URL+"/stock/v2/get-profile?symbol="+ticker+"&"+REGION_DATA, 
						HttpMethod.GET,
						getHeaders(),
						ApiData.class
					);
		
		
		return searchResults.getBody();
	}
	
	private HttpEntity<Map<String, Object>> getHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); 
		headers.add("X-RapidAPI-Host", HOST);
		headers.add("X-RapidAPI-Key", API_KEY);
		
		Map<String, Object> map = new HashMap<>();
		map.put("x-rapidapi-host", HOST);
		map.put("x-rapidapi-key", API_KEY);

		return new HttpEntity<>(map, headers);
	}
	

}
