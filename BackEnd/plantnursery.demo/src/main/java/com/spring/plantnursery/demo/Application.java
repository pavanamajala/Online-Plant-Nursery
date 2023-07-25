package com.spring.plantnursery.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Employee API",version="1.0",description="An API used for Employeess."))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
