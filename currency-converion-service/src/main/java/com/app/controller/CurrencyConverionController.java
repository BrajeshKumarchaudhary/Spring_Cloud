package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ConvertedValue;
import com.app.service.CurrencyService;

@RestController
@RequestMapping(value = "currency-conversion")
public class CurrencyConverionController {
	@Autowired
	CurrencyService currencyService;

	@GetMapping(value = "courrency-convert")
	public ConvertedValue getConvertedValue(
			@RequestParam(value = "from", required = true, defaultValue = "USD") String from,
			@RequestParam("to") String to, @RequestParam("value") double value) {
		return currencyService.getCurrencyConvertedValue(from, to, value);
	}

	@GetMapping(value = "rabbitmq-putmessage")
	public String putMessage() {
		return "SUCCESS";
	}

}
