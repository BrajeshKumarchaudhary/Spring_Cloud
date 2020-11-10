package com.app.service;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.FeignService;
import com.app.common.Output;
import com.app.common.SampleOutPut;

/**
 * @author brajesh
 *
 */
@Service
public class ChallengeService {

	@Autowired
	FeignService apiCallService;
	private String userId="zc_FMrOm";
	
	/**
	 * @return Description about challenge 
	 */
	public Object getAllChallenge() {
		return apiCallService.getAllChallenges(userId);
	}

	/**
	 * @return response of solve challenge
	 */
	public String solveChallenge() {
		String inputData=apiCallService.getInput(userId);
		System.out.println("Text--"+inputData);
		SampleOutPut outputData=countCharacters(inputData);
		System.out.println("Count--"+outputData.getOutput().getCount());
		String response=apiCallService.putOutput(userId, outputData);
		return response;
	}

	/**
	 * @param inputData
	 * @return count of characters in String
	 */
	private SampleOutPut countCharacters(String inputData) {
		StringTokenizer token=new StringTokenizer(inputData," ",true);
		long count=0;
		while(token.hasMoreElements()) {
			char arr[]=token.nextToken().toCharArray();
			count=count+arr.length;
		}
		SampleOutPut output=new SampleOutPut();
		Output outputData=new Output();
		outputData.setCount(count);
		output.setOutput(outputData);
		return output;
	}
}
