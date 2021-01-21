package com.java.app;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringZipkinApplication {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(SpringZipkinApplication.class);

	@GetMapping("/gettext")
	public String getText() {
		log.info("Called");
		return "Hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringZipkinApplication.class, args);
	}

}
