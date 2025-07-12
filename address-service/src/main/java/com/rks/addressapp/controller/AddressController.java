package com.rks.addressapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rks.addressapp.response.AddressResponse;
import com.rks.addressapp.service.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AddressController {

	private final AddressService service;

	@GetMapping("/address/{empId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("empId") Integer empid) {
		AddressResponse response = null;
		response = service.getAddressByEmployeeId(empid);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
