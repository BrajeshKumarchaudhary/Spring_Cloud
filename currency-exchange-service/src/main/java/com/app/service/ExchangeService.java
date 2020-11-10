package com.app.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.app.bean.CurrencyValue;

@Service
public class ExchangeService {
	private double exchangeRate = 65;
	@Autowired
	private Environment env;
	private Map<String, Map<String, BigDecimal>> currencymap=new HashMap<>();

	public ExchangeService() {
		Map<String, BigDecimal> map = new HashMap<>();
		map.put("USD", new BigDecimal(65));
		map.put("AUD", new BigDecimal(75));
		map.put("EUR", new BigDecimal(85));
		currencymap.put("INR", map);
	}

	public CurrencyValue getInrValue(double usd) {
		CurrencyValue value = new CurrencyValue();
		value.setConverionValue(new BigDecimal(exchangeRate));
		value.setFrom("Usd");
		value.setTo((usd * exchangeRate) + "");
		value.setPort(env.getProperty("server.port"));
		return value;
	}

	public CurrencyValue getInrValue(String from, String to) {
		BigDecimal conversionValue=currencymap.get(to).get(from);
		CurrencyValue value = new CurrencyValue();
		value.setConverionValue(conversionValue);
		value.setFrom(from);
		value.setTo(to);
		value.setPort(env.getProperty("server.port"));
		return value;
	}

}
