package com.app.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.ConvertedValue;

@Service
public class CurrencyService {
	@Autowired
	RestService restService;

	public ConvertedValue getCurrencyConvertedValue(String from, String to, double value) {
		ConvertedValue currencyValue=new ConvertedValue();
		ConvertedValue exchangeValue=restService.getCurrencyExchangeValueUsingFeign(from, to);
		currencyValue.setConvertedValue(new BigDecimal(value).multiply(exchangeValue.getConverionValue()));
		currencyValue.setFrom(from);
		currencyValue.setTo(to);
		currencyValue.setConverionValue(exchangeValue.getConverionValue());
		currencyValue.setPort(exchangeValue.getPort());
		return currencyValue;
	}

}
