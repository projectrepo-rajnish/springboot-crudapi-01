package com.rajnish.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajnish.dto.EmployeeDTO;
import com.rajnish.services.EmployeeServices;

@RestController
@RequestMapping("api/employees/")
public class EmployeeController {

	private EmployeeServices service;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	public EmployeeController(EmployeeServices service) {
		super();
		this.service = service;
		logger.info("Service injected inside EmployeeController::");
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee){
		logger.info("API triggered to save the employee details for empoloyee::"+employee.getFirstName());
		EmployeeDTO createEmployee = this.service.createEmployee(employee);
		
		return new ResponseEntity<>(createEmployee,HttpStatus.OK);
	}
}
