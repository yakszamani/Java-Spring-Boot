package org.easyspring.learn_spring_boot.services;

import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Employee;
import org.easyspring.learn_spring_boot.domain.UserStory;
import org.easyspring.learn_spring_boot.repository.EmployeeRepository;
import org.easyspring.learn_spring_boot.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserStoryServiceImplementation implements UserStoryService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserStoryRepository userStoryRepository;

    @Override
    @Transactional
    public Employee createEmployeeAndUserStory (Employee input) {

        //for every userstory, we are setting the Employee value. Since objects are passed by reference
        for (UserStory userStoryIn : input.getUserStories()) {
            userStoryIn.setEmployee(input);
        }
        // save Employee
        Employee employeeOut = employeeRepository.save(input);
        return employeeOut;
    }

    @Override
    public String setuserStoryForEmployee(Long id, String UserStory) {
        // fetch Employee
        Employee Employeetemp = employeeRepository.getById(id);
        // list of tasks
        List<UserStory> userStories = Employeetemp.getUserStories();
        // new Task
        UserStory newUserStory = new UserStory(UserStory);
        // set employees to userstories
        newUserStory.setEmployee(Employeetemp);
        // add Task to list
        userStories.add(newUserStory);
        // add Task list to Student
        //studentTemp.setTaskList(tasks); //not required due to pass by reference
        // save Employee
        employeeRepository.save(Employeetemp);
        return "User Story has been successfully saved!!!";
    }

    @Override
    public List<UserStory> findByEmployeeId(Long employeeId) {
        return userStoryRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<UserStory> all() {
        return userStoryRepository.findAll();
    }
}
