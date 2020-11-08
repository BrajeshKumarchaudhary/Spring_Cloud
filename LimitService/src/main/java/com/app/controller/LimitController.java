package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.LimitConfig;
import com.app.bean.LimitConfigurationProp;

@RestController
public class LimitController {

	
	@Autowired
	private LimitConfigurationProp prop;
	
	@GetMapping(value = "getTxnSaleLimit")
	public LimitConfig getSaleTxnLimit() {
		return new LimitConfig(prop.getMax(), prop.getMin());
	}
}
