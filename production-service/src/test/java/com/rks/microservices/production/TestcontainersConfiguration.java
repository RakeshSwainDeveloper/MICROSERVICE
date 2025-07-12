package com.rks.microservices.production;

import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

//	@Bean
//	@ServiceConnection
//	MongoDBContainer mongoDbContainer() {
//		return new MongoDBContainer(DockerImageName.parse("mongo:latest"));
//	}

}
