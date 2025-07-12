package com.rks.employeeapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rks.employeeapp.response.EmployeeResponse;
import com.rks.employeeapp.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable Integer id) {
		EmployeeResponse response = employeeService.getEmployeeDetails(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
