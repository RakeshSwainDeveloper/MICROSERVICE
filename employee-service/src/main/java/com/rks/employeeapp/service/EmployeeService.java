package com.rks.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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
//	private final RestTemplate restTemplate;
	private final WebClient webClient;

	public EmployeeResponse getEmployeeDetails(Integer id) {

		AddressResponse addressResponse = new AddressResponse();
		EmployeeEntity employee = repo.findById(id).get();
//		EmployeeResponse response = EmployeeResponse.builder().id(employee.getId()).name(employee.getName())
//				.name(employee.getName()).bloodgroup(employee.getBloodgroup()).build();
		EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
//		addressResponse = restTemplate.getForObject(rootUrl + "/address/{id}", AddressResponse.class, id);
//		addressResponse = callingAddressServuceUsingRestTemplate(id);
		addressResponse = webClient.get().uri("/address/{id}", id).retrieve().bodyToMono(AddressResponse.class).block();
		response.setAddressResponse(addressResponse);
		return response;
	}

//	private AddressResponse callingAddressServuceUsingRestTemplate(Integer id) {
//		return restTemplate.getForObject("/address/{id}", AddressResponse.class, id);
//	}

}
