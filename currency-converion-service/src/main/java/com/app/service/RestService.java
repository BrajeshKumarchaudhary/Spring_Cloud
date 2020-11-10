package com.app.service;

import java.util.HashMap;
import java.util.Map;

import org.bouncycastle.crypto.tls.HashAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.model.ConvertedValue;

@Service
public class RestService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private FeignService feignService;

	public ConvertedValue getCurrencyExchangeValue(String from, String to) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8000/currency-exchange/convert")
		        .queryParam("from", from)
		        .queryParam("to", to);
		ResponseEntity<ConvertedValue> entity = restTemplate.getForEntity(builder.toUriString(),ConvertedValue.class);
		ConvertedValue body = entity.getBody();
		return body;
	}
	
	public ConvertedValue getCurrencyExchangeValueUsingFeign(String from, String to) {
		return feignService.getExchangeValue(from, to);
	}
}
