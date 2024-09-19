package org.easyspring.learn_spring_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStoryDTO {
    private Long id;
    private String title;
    private  EmployeeDTO employee;

    public UserStoryDTO(UserStory UserStories, Employee employee) {
        this.id = UserStories.getId();
        this.title = UserStories.getTitle();
        this.employee = new EmployeeDTO(employee);
    }

}
