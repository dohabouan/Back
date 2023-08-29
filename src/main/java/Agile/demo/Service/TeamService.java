package Agile.demo.Service;

import Agile.demo.Entities.Feedback;
import Agile.demo.Entities.Team;

import java.util.List;

public interface TeamService {
    Team create (Team team);
    Team findById(Integer id);
    void delete(Integer id);
    Team update( Integer id,Team updatedTeam);
    List<Team> findAll();
}
