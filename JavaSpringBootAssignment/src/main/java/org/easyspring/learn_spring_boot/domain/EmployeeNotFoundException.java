package org.easyspring.learn_spring_boot.domain;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Could not find this Employee Entity: " + id);
    }
}