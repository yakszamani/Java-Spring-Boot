package org.easyspring.learn_spring_boot.repository;

import org.easyspring.learn_spring_boot.domain.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoryRepository  extends JpaRepository<UserStory, Long> {
    List<UserStory> findByEmployeeId (Long EmployeeId);
}
