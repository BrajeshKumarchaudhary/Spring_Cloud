package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.ApiConstant;
import com.app.common.CommonResponse;
import com.app.common.SampleOutPut;
import com.app.service.ChallengeService;

@RestController
@RequestMapping(value = "http-hunt")
public class ChallengeController {

	@Autowired
	ChallengeService service;
	
	@GetMapping(value = "getChallenge")
	public CommonResponse getAllChallenge() {
		CommonResponse response=new CommonResponse();
		try {
		Object apiData=service.getAllChallenge();
		response.setApiReponseCode(ApiConstant.SUCCESS_CODE);
		response.setApiResponseMessage(ApiConstant.SUCCESS_MESSAGE);
		response.setResponseData(apiData);
		}catch (Exception e) {
			response.setApiReponseCode(ApiConstant.EXCEPTION_CODE);
			response.setApiResponseMessage(ApiConstant.EXCEPTION_MESSAGE+e.getMessage());
			response.setResponseData(null);
		}
		return response;
	}

	@GetMapping(value = "solveChallenge")
	public CommonResponse solveChallenge() {
		CommonResponse response=new CommonResponse();
		try {
		String outPutData=service.solveChallenge();
		response.setApiReponseCode(ApiConstant.SUCCESS_CODE);
		response.setApiResponseMessage(ApiConstant.SUCCESS_MESSAGE);
		response.setResponseData(outPutData);
		}catch (Exception e) {
			response.setApiReponseCode(ApiConstant.EXCEPTION_CODE);
			response.setApiResponseMessage(ApiConstant.EXCEPTION_MESSAGE+e.getMessage());
			response.setResponseData(null);
		}
		return response;
	}
	
}
