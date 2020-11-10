package com.app.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


/**
 * @author brajesh
 *This interface is used to do api call
 */
@FeignClient(name = "http-hunt",url = "https://http-hunt.thoughtworks-labs.net/")
@Service
public interface FeignService {	
	
	/**
	 * @param userId
	 * @return problem description
	 */
	@GetMapping(value = "challenge",produces = "application/json")
	Object getAllChallenges(@RequestHeader("userId") String userId);
	
	/**
	 * @param userId
	 * @return challenge
	 */
	@GetMapping(value = "/challenge/input",produces = "application/json")
	String getInput(@RequestHeader("userId") String userId);
	
	/**
	 * @param userId
	 * @param output
	 * @return output response
	 */
	@PostMapping(value = "/challenge/output",produces = "application/json")
	String putOutput(@RequestHeader("userId") String userId,@RequestBody SampleOutPut output);
}
