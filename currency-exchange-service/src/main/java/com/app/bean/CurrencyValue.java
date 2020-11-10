package com.app.bean;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyValue {
	private Long id;
	private String to;
	private String from;
	private BigDecimal converionValue;
	private String port;
}
