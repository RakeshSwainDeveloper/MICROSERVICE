package com.rks.employeeapp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse {
	private Integer id;
	private String lane1;
	private String lane2;
	private Long zip;
	private String state;
}
