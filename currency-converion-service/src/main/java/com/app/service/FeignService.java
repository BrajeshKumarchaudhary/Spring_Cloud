package com.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ConvertedValue;

@FeignClient(name = "currency-exchange-service",url = "http://localhost:8000")
public interface FeignService {
	@GetMapping(value = "/currency-exchange/convert")
	public ConvertedValue getExchangeValue(@RequestParam("from") String from,@RequestParam("to") String to);
}
