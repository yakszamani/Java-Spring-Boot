package org.easyspring.learn_spring_boot.controllers;

import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Project;
import org.easyspring.learn_spring_boot.domain.Employee;
import org.easyspring.learn_spring_boot.services.ProjectService;
import org.easyspring.learn_spring_boot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
@Table(name = "projects")
public class ProjectController {
    @Autowired
    private ProjectService ProjectService;
    @Autowired
    private EmployeeService EmployeeService;

    @GetMapping("/allprojects")
    public List<Project> getProjects() {
        return ProjectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project get(@PathVariable Long id) {
        return ProjectService.getProjectsById(id);
    }

    @PostMapping("/saveprojects")
    public String saveProjects(@RequestBody Project project) {
        ProjectService.saveprojects(project);
        return "Project has been successfully saved!";
    }

    @PostMapping("/projectregistration/employee/{EmployeeId}/Project/{ProjectId}")
    public String projectRegistration(
            @PathVariable Long EmployeeId,
            @PathVariable Long ProjectId) {

        Employee employee = EmployeeService.findEmployee(EmployeeId);
        Project project = ProjectService.getProjectsById(ProjectId);

        if (employee != null && project != null) {
            employee.getProjects().add(project);

            EmployeeService.createEmployee(employee);

        } else {
            // Handle invalid student or course IDs
            throw new RuntimeException("Invalid Employee or employee ID");
        }
        return "New Project Assigned to Employee!";
    }
}
