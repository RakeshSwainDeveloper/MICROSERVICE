package com.rks.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rks.employeeapp.entity.EmployeeEntity;
import com.rks.employeeapp.feignclien.AddressClient;
import com.rks.employeeapp.repostitory.EmployeeRepository;
import com.rks.employeeapp.response.AddressResponse;
import com.rks.employeeapp.response.EmployeeResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository repo;
	private final ModelMapper modelMapper;
	private final AddressClient addressClient;

	public EmployeeResponse getEmployeeDetails(Integer id) {

		AddressResponse addressResponse = null;
		EmployeeEntity employee = repo.findById(id).get();
		EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
		ResponseEntity<AddressResponse> addressByEmployeeId = addressClient.getAddressByEmployeeId(id);
		addressResponse = addressByEmployeeId.getBody();
		response.setAddressResponse(addressResponse);
		return response;
	}

}
