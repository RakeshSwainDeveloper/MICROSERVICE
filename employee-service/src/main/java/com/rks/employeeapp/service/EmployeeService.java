package com.rks.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rks.employeeapp.entity.EmployeeEntity;
import com.rks.employeeapp.repostitory.EmployeeRepository;
import com.rks.employeeapp.response.AddressResponse;
import com.rks.employeeapp.response.EmployeeResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

//	@Value("${addressservice.base.url}")
//	private String rootUrl;

	private final EmployeeRepository repo;
	private final ModelMapper modelMapper;
	private final RestTemplate restTemplate;
	private final DiscoveryClient discoveryClient;
	private final LoadBalancerClient loadBalancerClient;
//	private final WebClient webClient;

	public EmployeeResponse getEmployeeDetails(Integer id) {

		AddressResponse addressResponse = new AddressResponse();
		EmployeeEntity employee = repo.findById(id).get();
//		EmployeeResponse response = EmployeeResponse.builder().id(employee.getId()).name(employee.getName())
//				.name(employee.getName()).bloodgroup(employee.getBloodgroup()).build();
		EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
//		addressResponse = restTemplate.getForObject(rootUrl + "/address/{id}", AddressResponse.class, id);
		addressResponse = callingAddressServuceUsingRestTemplate(id);
//		addressResponse = callToAddressServiceByUsingWebClient(id);
		response.setAddressResponse(addressResponse);
		return response;
	}

//	private AddressResponse callToAddressServiceByUsingWebClient(Integer id) {
//		return webClient.get().uri("/address/{id}", id).retrieve().bodyToMono(AddressResponse.class).block();
//	}

	private AddressResponse callingAddressServuceUsingRestTemplate(Integer id) {
		List<ServiceInstance> instances = discoveryClient.getInstances("address-service");
		ServiceInstance serviceInstance = instances.get(0);
		String addressServiceUrl = serviceInstance.getUri().toString();
		System.out.println("Address Service URL: " + addressServiceUrl);
		return restTemplate.getForObject(addressServiceUrl + "/address-app/api/address/{id}", AddressResponse.class,
				id);
	}

}
