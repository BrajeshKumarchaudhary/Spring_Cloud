package com.app.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ConvertedValue {
private String from;
private String to;
private BigDecimal convertedValue;
private BigDecimal converionValue;
private String port;
}
