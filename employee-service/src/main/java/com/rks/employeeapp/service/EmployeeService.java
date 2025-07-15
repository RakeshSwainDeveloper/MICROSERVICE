package com.rks.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rks.employeeapp.entity.EmployeeEntity;
import com.rks.employeeapp.openFeignClients.AddressClient;
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
//	private final DiscoveryClient discoveryClient;
//	private final LoadBalancerClient loadBalancerClient;
//	private final WebClient webClient;
	private final AddressClient addressClient;

	public EmployeeResponse getEmployeeDetails(Integer id) {

		AddressResponse addressResponse = new AddressResponse();
		EmployeeEntity employee = repo.findById(id).get();
//		EmployeeResponse response = EmployeeResponse.builder().id(employee.getId()).name(employee.getName())
//				.name(employee.getName()).bloodgroup(employee.getBloodgroup()).build();
		EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
//		addressResponse = restTemplate.getForObject(rootUrl + "/address/{id}", AddressResponse.class, id);
//		addressResponse = callingAddressServuceUsingRestTemplate(id);
//		addressResponse = callToAddressServiceByUsingWebClient(id);
		addressResponse = addressClient.getAddressByEmployeeId(id).getBody();
		response.setAddressResponse(addressResponse);
		return response;
	}

//	private AddressResponse callToAddressServiceByUsingWebClient(Integer id) {
//		return webClient.get().uri("/address/{id}", id).retrieve().bodyToMono(AddressResponse.class).block();
//	}

	private AddressResponse callingAddressServuceUsingRestTemplate(Integer id) {

		// Using DiscoveryClient to get the service instance
		// -----------------------------------------------------------------------
//		List<ServiceInstance> instances = discoveryClient.getInstances("address-service");
//		ServiceInstance serviceInstance = instances.get(0);
//		String addressServiceUrl = serviceInstance.getUri().toString();

//		-- Using LoadBalancerClient to get the service instance---------------

//		ServiceInstance serviceInstance = loadBalancerClient.choose("address-service");
//		String addressServiceUrl = serviceInstance.getUri().toString();
//		String contextRoot = serviceInstance.getMetadata().get("configpath");
//		System.out.println("Address Service URL: " + addressServiceUrl);
//		System.out.println("Context Root: " + contextRoot);
//		return restTemplate.getForObject(addressServiceUrl + contextRoot+"/address/{id}", AddressResponse.class,
//				id);
		// -----------------------------------------------------------------------

		// Using RestTemplate with LoadBalancer to call the address service
		// This will automatically use the load balancer to find the correct instance
		// Using RestTemplate with LoadBalancer to call the address service
		return restTemplate.getForObject("http://ADDRESS-SERVICE/address-app/api/address/{id}", AddressResponse.class,
				id);
	}

}
