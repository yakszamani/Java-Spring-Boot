package org.easyspring.learn_spring_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String EmployeeName;
    private String EmployeeEmail;
    private String EmployeeAddress;
    private String EmployeePhone;
    private LocalDateTime enrollDate;
    private Boolean activeEnrollment;
    private List<UserStory> Userstories;


    public  EmployeeDTO(Employee employee, List<UserStory> Userstories) {
        this.id = employee.getId();
        this.EmployeeName = employee.getEmployeeName();
        this.EmployeeEmail = employee.getEmployeeEmail();
//      this.EmployeePhone = employee.getEmployeePhone();
//      this.EmployeeAddress = employee.getEmployeeAddress();
        this.enrollDate = employee.getEnrollDate();
        this.activeEnrollment = employee.getActiveEnrollment();
        this.Userstories = Userstories;
    }

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.EmployeeName = employee.getEmployeeName();
        this.EmployeeEmail = employee.getEmployeeEmail();
        this.enrollDate = employee.getEnrollDate();
        this.activeEnrollment = employee.getActiveEnrollment();

    }

}
