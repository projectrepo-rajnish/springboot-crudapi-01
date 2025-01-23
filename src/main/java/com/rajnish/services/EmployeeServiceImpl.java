package com.rajnish.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rajnish.controller.EmployeeController;
import com.rajnish.dto.EmployeeDTO;
import com.rajnish.entity.Employee;
import com.rajnish.mapper.EmployeeDTOMapper;
import com.rajnish.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

	private EmployeeRepository repo;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	public EmployeeServiceImpl(EmployeeRepository repo) {
		super();
		this.repo = repo;
		logger.debug("EmployeeService object created::");
	}

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		logger.debug("EmployeeService createEmployee triggered::");
		logger.info("EmployeeService createEmployee triggered testing::");
		Employee convertToEmploye = EmployeeDTOMapper.convertToEmploye(employeeDTO);
		Employee save = this.repo.save(convertToEmploye);
		EmployeeDTO convertToEmployeeDTO = EmployeeDTOMapper.convertToEmployeeDTO(save);
		logger.debug("EmployeeService createEmployee triggered::");
		return convertToEmployeeDTO;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
