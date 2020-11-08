package com.app.service;

import org.springframework.stereotype.Service;

import com.app.bean.CurrencyValue;

@Service
public class ExchangeService {
    private double exchangeRate=65;
	
	
	public CurrencyValue getInrValue(double usd) {
		return new CurrencyValue(usd*exchangeRate);
	}

}
