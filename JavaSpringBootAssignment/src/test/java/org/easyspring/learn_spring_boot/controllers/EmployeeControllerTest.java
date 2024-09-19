package org.easyspring.learn_spring_boot.controllers;

import org.easyspring.learn_spring_boot.controllers.EmployeeController;
import org.easyspring.learn_spring_boot.domain.Employee;
import org.easyspring.learn_spring_boot.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService service;

    @InjectMocks
    private EmployeeController controller;

    @Test
    public void allEmployeesTest() {
        List<Employee> mockEmployees = createMockEmployees();
        when(service.all()).thenReturn(mockEmployees);

        List<Employee> employees = controller.all();

        assertEquals(mockEmployees, employees);
    }

    @Test
    public void findEmployeeTest() {
        Long employeeId = 1L;
        Employee mockEmployee = createMockEmployee(employeeId);
        when(service.findEmployee(employeeId)).thenReturn(mockEmployee);

        Employee employee = controller.one(employeeId);

        assertEquals(mockEmployee, employee);
    }


    @Test
    public void registerNewEmployeeTest() {
        Employee EmployeeToRegister = createMockEmployee(null);
        Employee createdEmployee= createMockEmployee(2L);
        when(service.createEmployee(EmployeeToRegister)).thenReturn(createdEmployee);

        ResponseEntity<Employee> response = controller.registerEmployee(EmployeeToRegister);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdEmployee, response.getBody());
    }

    // Helper method to create mock Student objects
    private List<Employee> createMockEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "John Doe", "john.doe@example.com","Jonathan Drivbe", "855-222-3020", 50000, LocalDateTime.now(), true, null, null));
        // Add more students as needed for your tests
        return employees;
    }


    private Employee createMockEmployee(Long id) {
        return new Employee(id, "New Employee", "new.emp@example.com", "Jonathan Drivbe", "855-222-3020", 50000, LocalDateTime.now(), true, null, null);
    }

}
