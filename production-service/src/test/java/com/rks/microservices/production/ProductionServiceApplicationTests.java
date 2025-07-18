package com.rks.microservices.production;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;

//@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductionServiceApplicationTests {

//	@ServiceConnection
//	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void sertp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

//	static {
//		mongoDBContainer.start();
//	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
				"name":"Rakesh",
				"description":"Developer",
				"price":60000
				}
				""";

		RestAssured.given().contentType("application/json").body(requestBody).when().post("/api/product").then()
				.statusCode(201).body("id", Matchers.notNullValue()).body("name", Matchers.equalTo("Rakesh"))
				.body("description", Matchers.equalTo("Developer")).body("price", Matchers.equalTo(60000));

	}

}
