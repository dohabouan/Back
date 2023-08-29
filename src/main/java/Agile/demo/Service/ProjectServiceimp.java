package Agile.demo.Service;

import Agile.demo.Entities.Project;
import Agile.demo.Repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceimp implements ProjectService{
    private final ProjectRepository projectRepository;

    public ProjectServiceimp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project create (Project project) {

        return projectRepository.save(project);
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Project not found"));
    }

    @Override
    public void delete(Integer id) {
        Project project=projectRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Project not found"));
        projectRepository.delete(project);

    }

    @Override
    public Project update( Integer id,Project updatedProjet) {
        Project project1=projectRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Project not found"));
        project1.setId(updatedProjet.getId());
        project1.setStartDate(updatedProjet.getStartDate());
        project1.setEndDate(updatedProjet.getEndDate());

        return projectRepository.save(project1);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}
