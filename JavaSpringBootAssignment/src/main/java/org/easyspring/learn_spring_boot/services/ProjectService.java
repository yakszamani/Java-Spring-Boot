package org.easyspring.learn_spring_boot.services;

import org.easyspring.learn_spring_boot.domain.Project;

import java.util.List;

public interface ProjectService {
    public List<Project> getAllProjects();

    public void saveprojects(Project project);

    public Project getProjectsById(Long id);

}
