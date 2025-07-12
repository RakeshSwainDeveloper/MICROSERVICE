package com.rks.addressapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rks.addressapp.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	// address based on a employee id
	@Query(nativeQuery = true, value = "SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM microservice.address ea join "
			+ "microservice.employee e on e.id = ea.employee_id where ea.employee_id = :employeeId;")
	public Address getAddressByEmployeeId(@Param("employeeId") Integer empId);


}
