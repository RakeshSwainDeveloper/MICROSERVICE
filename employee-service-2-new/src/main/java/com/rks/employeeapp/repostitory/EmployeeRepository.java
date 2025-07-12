package com.rks.employeeapp.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rks.employeeapp.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
