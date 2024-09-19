package org.easyspring.learn_spring_boot.services;

import org.easyspring.learn_spring_boot.domain.Employee;
import org.easyspring.learn_spring_boot.domain.UserStory;

import java.util.List;

public interface UserStoryService {
    Employee createEmployeeAndUserStory(Employee input);

    String setuserStoryForEmployee(Long id, String UserStory);

    List<UserStory> findByEmployeeId(Long EmployeeId);

    List<UserStory> all();

}
