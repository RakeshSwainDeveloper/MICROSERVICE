package com.rks.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.rks.addressapp.entity.Address;
import com.rks.addressapp.repository.AddressRepo;
import com.rks.addressapp.response.AddressResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

	private final AddressRepo addressRepo;
	private final ModelMapper modelMapper;

	public AddressResponse getAddressByEmployeeId(Integer empId) {
		Address address = addressRepo.getAddressByEmployeeId(empId);
		AddressResponse response = modelMapper.map(address, AddressResponse.class);
		return response;
	}

}
