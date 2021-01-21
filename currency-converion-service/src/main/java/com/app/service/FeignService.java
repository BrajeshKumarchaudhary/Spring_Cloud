package com.app.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ConvertedValue;

//@FeignClient(name = "currency-exchange-service",url = "http://localhost:8000")
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface FeignService {
	@GetMapping(value = "/currency-exchange/convert")
	public ConvertedValue getExchangeValue(@RequestParam("from") String from,@RequestParam("to") String to);
}
