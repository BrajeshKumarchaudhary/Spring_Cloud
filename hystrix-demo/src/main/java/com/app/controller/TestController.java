package com.app.controller;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {

	@RequestMapping(value = "/test")
	@HystrixCommand(fallbackMethod = "defaultMethod")
	public String getData() {
		System.out.println("=========================called====================");
		return new RuntimeException().getMessage();
	}

	public String defaultMethod() {
		return "I am fallback method";
	}
}
