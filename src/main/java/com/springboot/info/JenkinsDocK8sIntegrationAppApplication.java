package com.springboot.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsDocK8sIntegrationAppApplication {
	
	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to JenkinsDocK8sIntegrationAppApplication!";
	}
	@GetMapping("/hello")
	public String hello() {
		return "Hello, Good Morning!";
	}

	public static void main(String[] args) {
		SpringApplication.run(JenkinsDocK8sIntegrationAppApplication.class, args);
	}

}
