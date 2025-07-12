package com.rks.microservices.production;

import org.springframework.boot.SpringApplication;

public class TestProductionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductionServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
