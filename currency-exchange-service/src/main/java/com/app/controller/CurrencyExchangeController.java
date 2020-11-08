package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.CurrencyValue;
import com.app.service.ExchangeService;

@RestController
@RequestMapping(value = "currency-exchange")
public class CurrencyExchangeController {
@Autowired
private ExchangeService service;
	
     @GetMapping(value = "convert")
	public CurrencyValue convert(@RequestParam("usd")  double usd) {
		return service.getInrValue(usd);
	}
}
