package org.easyspring.learn_spring_boot.repository;

import org.easyspring.learn_spring_boot.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT em FROM Employee em WHERE em.id = ?1 OR em.employeeName = ?2")
    List<Employee> findAsOfDateEntities(
            Long id, String employeeName);

    @Query(value = "SELECT em FROM Employee em WHERE em.enrollDate <= ?1 AND em.activeEnrollment = ?2")
    List<Employee> findAsOfDateEmployees(
            LocalDateTime enrollDate, Boolean activeEnrollment);

    @Query(value = "SELECT em FROM Employee em WHERE em.employeeSalary >= ?1 AND em.activeEnrollment = ?2")
    List<Employee> findHighSalary(
             double employeeSalary,  Boolean activeEnrollment);
}
