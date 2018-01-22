package com.example.factorisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.factorisation.TestData;

@SpringBootApplication
public class FactorisationApplication {
	
	@SuppressWarnings("unused")
	@Autowired
	private TestData testData;

	public static void main(String[] args) {
		SpringApplication.run(FactorisationApplication.class, args);
	}
}
