package org.easyspring.learn_spring_boot.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Employee;
import org.easyspring.learn_spring_boot.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    //http://localhost:8080/EmployeeList
    @GetMapping("/EmployeeList")
    public List<Employee> all() {
        return service.all();
    }

    //http://localhost:8080/registerEmployee
    @PostMapping("/registerEmployee")
    public ResponseEntity<?> registerEmployee(@RequestBody @Valid Employee employee) {
        Employee createdEmployee = service.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }



    //http://localhost:8080/findEmployee/1
    @GetMapping("/findEmployee/{id}")
    public Employee one(@PathVariable Long id) {
        return service.findEmployee(id);
    }

    //http://localhost:8080/updateEmployee/1
    @PutMapping("/updateEmployee/{id}")
    Employee upsert(@RequestBody Employee input, @PathVariable Long id) {
        return service.upsertGeicoDomain(input, id);
    }

    //http://localhost:8080/deleteEmployee/1
    @DeleteMapping("/deleteEmployee/{id}")
    void delete(@PathVariable Long id) {
        service.deleteEmployees(id);
    }
    //http://localhost:8080/employeeSearchByIdorName?id=1&studentName=John
    @GetMapping(value = "/employeeSearchByIdorName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getResources(
            @RequestParam Long id,
            @RequestParam String EmployeeName
    ) {
        return new ResponseEntity<>
                (service.getEmployees(id, EmployeeName), HttpStatus.OK);
    }

    //http://localhost:8080/employeesByDate?enrollDate=2021-07-01T00:00:00&activeEnrollment=true
    @GetMapping(value = "/EmployeesByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getStudentsByDate(
            @RequestParam String enrollDate,
            @RequestParam Boolean activeEnrollment
    ) {
        return new ResponseEntity<>
                (service.getEmployeesByDate(LocalDateTime.parse(enrollDate), activeEnrollment), HttpStatus.OK);
    }

    @GetMapping(value = "/highSalary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getHighSalary(
            @RequestParam double EmployeeSalary,
            @RequestParam Boolean activeEnrollment
    ) {
        return new ResponseEntity<>
                (service.getHighSalary(EmployeeSalary, activeEnrollment), HttpStatus.OK);
    }
}
