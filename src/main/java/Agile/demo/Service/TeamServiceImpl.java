package Agile.demo.Service;

import Agile.demo.Entities.Feedback;
import Agile.demo.Entities.Team;
import Agile.demo.Repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team create(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team findById(Integer id) {
        return teamRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Team not found"));
    }

    @Override
    public void delete(Integer id) {
        Team team=teamRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Team not found"));
        teamRepository.delete(team);
    }

    @Override
    public Team update(Integer id, Team updatedTeam) {
        Team team1=teamRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Team not found"));
        team1.setId(updatedTeam.getId());
        team1.setUserStories(updatedTeam.getUserStories());
        team1.setCollaborators(updatedTeam.getCollaborators());
        team1.setProjects(updatedTeam.getProjects());
        return teamRepository.save(team1);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}

