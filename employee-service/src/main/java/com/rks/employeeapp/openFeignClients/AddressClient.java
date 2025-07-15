package com.rks.employeeapp.openFeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rks.employeeapp.response.AddressResponse;


@FeignClient(name = "ADDRESS-SERVICE", path = "/address-app/api")
public interface AddressClient {
	
	@GetMapping("/address/{empId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("empId") Integer empid);

}
