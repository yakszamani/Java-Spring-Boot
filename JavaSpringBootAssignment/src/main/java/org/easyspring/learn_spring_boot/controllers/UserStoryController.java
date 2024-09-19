package org.easyspring.learn_spring_boot.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.easyspring.learn_spring_boot.domain.Employee;
import org.easyspring.learn_spring_boot.domain.EmployeeDTO;
import org.easyspring.learn_spring_boot.domain.UserStory;
import org.easyspring.learn_spring_boot.domain.UserStoryDTO;
import org.easyspring.learn_spring_boot.services.EmployeeService;
import org.easyspring.learn_spring_boot.services.UserStoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userstory")
public class UserStoryController {

    private final EmployeeService employeeService;
    private final UserStoryService userStoryService;

    @PostMapping("/saveemployeeanduserstory")
    public String saveEmployeeAndUserStory(@RequestBody Employee employee) {

        Employee createdStudent = userStoryService.createEmployeeAndUserStory(employee);

        return "Employee and user story saved!!";
    }

    @PostMapping("/setuserstoryforemployee")
    public String setUserStoryforEmployee(@RequestParam(name = "id") String id, @RequestParam String userStory) {

        String result = userStoryService.setuserStoryForEmployee(Long.valueOf(id), userStory);
        return result;

    }

    @GetMapping("/allemployeeswithuserstories")
    public ResponseEntity<List<EmployeeDTO>> getAllStudentsWithTasks() {
        List<Employee> employees = employeeService.all();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for (Employee employee : employees) {
            List<UserStory> userStories = userStoryService.findByEmployeeId(employee.getId());
            employeeDTOS.add(new EmployeeDTO(employee, userStories));
        }

        return ResponseEntity.ok(employeeDTOS);
    }

    @GetMapping("/alluserstorywithemployees")
    public ResponseEntity<List<UserStoryDTO>> getAllTasksWithStudents() {
        List<UserStory> userStories =userStoryService.all();
        List<UserStoryDTO> UserStoryDTOs = new ArrayList<>();

        for (UserStory userStory : userStories) {
            Employee employee = userStory.getEmployee();
            UserStoryDTOs.add(new UserStoryDTO(userStory, employee));
        }

        return ResponseEntity.ok(UserStoryDTOs);
    }


}
