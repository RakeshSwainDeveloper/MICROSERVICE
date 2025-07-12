package com.rks.employeeapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppCOnfig {

	@Value("${addressservice.base.url}")
	private String baseUri;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Bean
//	public RestTemplate restTemplate() {
//		System.out.println("-----------" + baseUri);
//		RestTemplate restTemplate = new RestTemplate();
//		DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUri);
//		restTemplate.setUriTemplateHandler(factory);
//		return restTemplate;
//	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().baseUrl(baseUri).build();
	}
}
