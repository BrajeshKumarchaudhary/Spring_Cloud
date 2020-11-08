package com.app.bean;

import javax.annotation.sql.DataSourceDefinition;

public class LimitConfig {
	private int max;
	private int min;

	public int getMax() {
		return max;
	}

	public LimitConfig(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

}
