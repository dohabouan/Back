package Agile.demo.Service;

import Agile.demo.Entities.Project;

import java.util.List;

public interface ProjectService {
    Project create (Project project);
    Project findById(Integer id);
    void delete(Integer id);
    Project update( Integer id,Project updatedProjet);
    List<Project> findAll();

}
