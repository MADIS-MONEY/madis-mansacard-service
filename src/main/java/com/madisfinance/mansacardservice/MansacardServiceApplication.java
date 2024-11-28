package com.madisfinance.mansacardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Madis Mansa Card Operations API", version = "1.0", description = "Madis Card : User Card Management"))
public class MansacardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MansacardServiceApplication.class, args);
	}

}
