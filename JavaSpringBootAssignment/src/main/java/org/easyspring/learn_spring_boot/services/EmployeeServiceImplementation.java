package org.easyspring.learn_spring_boot.services;

import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Employee;
import org.easyspring.learn_spring_boot.domain.EmployeeNotFoundException;
import org.easyspring.learn_spring_boot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository EmployeeRepository;


    @Override
    public List<Employee> all() {
        return EmployeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee input) {
        return EmployeeRepository.save(input);
    }

    @Override
    public Employee findEmployee(Long id) {
        return EmployeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public List<Employee> getEmployees(Long id, String EmployeeName) {
        return EmployeeRepository.findAsOfDateEntities(id, EmployeeName);
    }

    @Override
    @Transactional
    public Employee upsertGeicoDomain(Employee upsertInput, Long id) {
        return EmployeeRepository.findById(id)
                .map(found -> {
                    found.setEmployeeName(upsertInput.getEmployeeName());
                    found.setEmployeeEmail(upsertInput.getEmployeeEmail());
                    found.setEmployeeAddress(upsertInput.getEmployeeAddress());
                    found.setEmployeePhone(upsertInput.getEmployeePhone());
                    found.setEnrollDate(upsertInput.getEnrollDate());
                    found.setActiveEnrollment(upsertInput.getActiveEnrollment());
                    return EmployeeRepository.save(found);
                })
                .orElseGet(() -> {
                    upsertInput.setId(id);
                    return EmployeeRepository.save(upsertInput);
                });
    }

    @Override
    public void deleteEmployees(Long id) {
        EmployeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByDate(LocalDateTime enrollDate, Boolean activeEnrollment) {
        return EmployeeRepository.findAsOfDateEmployees(enrollDate, activeEnrollment);
    }

    public List<Employee> getHighSalary(double EmployeeSalary, Boolean activeEnrollment) {
        return EmployeeRepository.findHighSalary(EmployeeSalary, activeEnrollment);
    }
}
