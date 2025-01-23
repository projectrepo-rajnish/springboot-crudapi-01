package com.rajnish.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.rajnish.dto.EmployeeDTO;
import com.rajnish.entity.Employee;
import com.rajnish.repository.EmployeeRepository;
import com.rajnish.services.EmployeeServiceImpl;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository repo;  // Mock the EmployeeRepository

    private EmployeeServiceImpl employeeService;  // Service to be tested

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
        employeeService = new EmployeeServiceImpl(repo);  // Initialize the service with mock repository
    }

    @Test
    void testCreateEmployee() {
        // Arrange: Create a mock EmployeeDTO and corresponding Employee
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("John");
        employeeDTO.setLastName("Doe");
        employeeDTO.setEmailid("john.doe@example.com");
        employeeDTO.setSalary(50000);
        employeeDTO.setCity("New York");

        Employee mockEmployee = new Employee(0, "John", "Doe", "john.doe@example.com", 50000, "New York");
        Employee savedEmployee = new Employee(1, "John", "Doe", "john.doe@example.com", 50000, "New York");

        // Mock the repository save method to return the saved entity with an id
        when(repo.save(any(Employee.class))).thenReturn(savedEmployee);

        // Act: Call the service method
        EmployeeDTO result = employeeService.createEmployee(employeeDTO);

        // Assert: Verify the result
        assertNotNull(result);  // Ensure the result is not null
        assertEquals(1, result.getId());  // Assert that the returned DTO has the ID set
        assertEquals("John", result.getFirstName());  // Assert first name is correct
        assertEquals("Doe", result.getLastName());  // Assert last name is correct
        assertEquals("john.doe@example.com", result.getEmailid());  // Assert email is correct
        assertEquals(50000, result.getSalary());  // Assert salary is correct
        assertEquals("New York", result.getCity());  // Assert city is correct

        // Verify that the save method was called once
        verify(repo, times(1)).save(any(Employee.class));
    }

    @Test
    void testCreateEmployee_WithEmptyFirstName() {
        // Arrange: Create a DTO with no first name (invalid case)
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("");  // Empty first name
        employeeDTO.setLastName("Doe");
        employeeDTO.setEmailid("john.doe@example.com");
        employeeDTO.setSalary(50000);
        employeeDTO.setCity("New York");

        // Act & Assert: Expect a validation exception or check how your service handles this case
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            employeeService.createEmployee(employeeDTO);
        });

        assertEquals("Employee creation failed", exception.getMessage());  // Ensure that the exception message is correct
    }
}

