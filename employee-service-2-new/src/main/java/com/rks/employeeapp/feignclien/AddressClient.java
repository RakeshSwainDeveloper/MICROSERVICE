package com.rks.employeeapp.feignclien;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rks.employeeapp.response.AddressResponse;

//http://localhost:8081/address-app/api/address/1
@FeignClient(name = "address-service", url = "${address.service.url}")
public interface AddressClient {

//	@GetMapping("/address/{id}")
//	AddressResponse getAddressByEmployeeId(@PathVariable("id") Integer id);
	
	@GetMapping("/address/{empId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("empId") Integer empid);
	
	
}
