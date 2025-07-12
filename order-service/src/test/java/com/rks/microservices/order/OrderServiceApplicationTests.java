package com.rks.microservices.order;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

	@LocalServerPort
	private int port;
	
	@BeforeEach
	void setUp() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port = port;
	}
	
	@Test
	void shouldPlaceOrderSuccessfully() {
		String requestBody = """
				
				""";
		RestAssured.given()
		.contentType("application/json")
		.body(requestBody)
		.when().post("/api/order").then().statusCode(201).body(equalTo("Order placed."));
	}

}
