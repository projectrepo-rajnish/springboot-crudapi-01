package com.rajnish.services;

import java.util.List;

import com.rajnish.dto.EmployeeDTO;

public interface EmployeeServices {

	public EmployeeDTO createEmployee(EmployeeDTO employee);
	public List<EmployeeDTO> getAllEmployees();
}
