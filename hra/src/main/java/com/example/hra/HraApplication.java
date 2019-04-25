package com.example.hra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HraApplication {

	public static void main(String[] args) {
		SpringApplication.run(HraApplication.class, args);
	}
	
	@RequestMapping("/hello")
	public String getHello() {
		System.out.println("In HRA App");
		return "Hello HRA";
	}
}
