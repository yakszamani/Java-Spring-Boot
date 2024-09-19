package org.easyspring.learn_spring_boot.services;

import org.easyspring.learn_spring_boot.domain.Employee;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeService {

    List<Employee> all();

    Employee createEmployee(Employee input);

    Employee findEmployee(Long id);

    List<Employee> getEmployees(Long id, String EmployeeName);

    Employee upsertGeicoDomain(Employee upsertInput, Long id);

    void deleteEmployees(Long id);

    List<Employee> getEmployeesByDate(LocalDateTime enrollDate, Boolean activeEnrollment);

    List<Employee> getHighSalary(double EmployeeSalary, Boolean activeEnrollment);
}
