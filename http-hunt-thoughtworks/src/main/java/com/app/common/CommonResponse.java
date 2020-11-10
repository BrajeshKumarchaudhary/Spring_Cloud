package com.app.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
	private String apiResponseMessage;
	private int apiReponseCode;
	private Object responseData;
}
