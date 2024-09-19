package org.easyspring.learn_spring_boot.services;

import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Project;
import org.easyspring.learn_spring_boot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImplementation implements ProjectService {
    @Autowired
    private ProjectRepository ProjectRepository;

    public List<Project> getAllProjects() {
        return ProjectRepository.findAll();
    }

    @Transactional
    public void saveprojects(Project Project) {
        ProjectRepository.save(Project);
    }

    public Project getProjectsById(Long id) {
        return ProjectRepository.findById(id).orElse(null);
    }

}
