package com.java.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
@Configuration
public class CloudConfig {
	 @Autowired
	    RestTemplate restTemplate;
//	@Bean
//	public AlwaysSampler defaultSampler()
//	{
//		return new AlwaysSampler();
//	}
	
	 
	    @Bean
	    public RestTemplate getRestTemplate() {
	        return new RestTemplate();
	    }
}
