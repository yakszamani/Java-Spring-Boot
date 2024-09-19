package org.easyspring.learn_spring_boot.repository;

import org.easyspring.learn_spring_boot.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectRepository extends JpaRepository<Project, Long> {
}