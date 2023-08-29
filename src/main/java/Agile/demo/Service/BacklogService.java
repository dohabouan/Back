package Agile.demo.Service;

import Agile.demo.Entities.Backlog;
import Agile.demo.Entities.Project;

import java.util.List;

public interface BacklogService {

    Backlog create (Backlog backlog);
    Backlog findById(Integer id);
    void delete(Integer id);
    Backlog update( Integer id,Backlog updatedBacklog);
    List<Backlog> findAll();
}
