package com.rks.employeeapp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

	private Integer id;
	private String name;
	private String email;
	private String bloodgroup;
	private AddressResponse addressResponse;

}
