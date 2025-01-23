package com.rajnish.mapper;

import com.rajnish.dto.EmployeeDTO;
import com.rajnish.entity.Employee;

public class EmployeeDTOMapper {

	public static EmployeeDTO convertToEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO=new EmployeeDTO(
				 employee.getId(),
				 employee.getFirstName(),
				 employee.getLastName(),
				 employee.getEmailid(),
				 employee.getSalary(),
				 employee.getCity()
				 );
		return employeeDTO;
	}
	
   public static Employee convertToEmploye(EmployeeDTO employeeDTO) {
		
	   Employee employee=new Employee(
			   employeeDTO.getId(),
			   employeeDTO.getFirstName(),
			   employeeDTO.getLastName(),
			   employeeDTO.getEmailid(),
			   employeeDTO.getSalary(),
			   employeeDTO.getCity()
				 );
		return employee;
	}
}
