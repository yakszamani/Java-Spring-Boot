package org.easyspring.learn_spring_boot.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity  //We use this to create tables in the database
    @Data  //getter and setter methods
    @Builder
    @NoArgsConstructor  // 0 argument constructor
    @AllArgsConstructor
    public class Employee {

        private @Id
        @GeneratedValue Long id;
        @NotNull
        @Size(min = 2, max = 30, message = "Name must be minimum 2 characters, and maximum 30 characters long")

        private String employeeName;
        @NotNull
        @Email
        private String employeeEmail;
        private String employeeAddress;
        private String employeePhone;
        private double employeeSalary;

        //Added this two after class today -  09/10/2024
        private LocalDateTime enrollDate;
        private Boolean activeEnrollment;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
        private List<UserStory> userStories;

        public Employee(String employeeName, String employeeEmail) {
            this.employeeName = employeeName;
            this.employeeEmail = employeeEmail;
        }

        @JsonManagedReference
        public List<UserStory> getUserStories() {
            return userStories;
        }


        @ManyToMany(fetch = FetchType.LAZY,
                cascade =
                        {
                                CascadeType.DETACH,
                                CascadeType.MERGE,
                                CascadeType.REFRESH,
                                CascadeType.PERSIST
                        },
                targetEntity = Project.class)
        @JoinTable(name = "Employee_projects",
                joinColumns = @JoinColumn(name = "employee_id"),
                inverseJoinColumns = @JoinColumn(name = "project_id"))
        private Set<Project> projects = new HashSet<>();
        }


