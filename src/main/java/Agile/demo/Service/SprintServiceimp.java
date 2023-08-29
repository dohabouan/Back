package Agile.demo.Service;

import Agile.demo.Entities.Project;
import Agile.demo.Entities.Sprint;
import Agile.demo.Repository.SprintRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SprintServiceimp implements SprintService{
    private SprintRepository sprintRepository;

    public SprintServiceimp(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    @Override
    public Sprint create(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    public Sprint findById(Integer id) {
        return sprintRepository.findById(id).orElseThrow(()->new EntityNotFoundException("sprint not found"));

    }

    @Override
    public void delete(Integer id) {
        Sprint sprint=sprintRepository.findById(id).orElseThrow(()->new EntityNotFoundException("sprint not found"));
        sprintRepository.delete(sprint);

    }

    @Override
    public Sprint update(Integer id, Sprint updatedSprint) {
        Sprint sprint1=sprintRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sprint not found"));
        sprint1.setId(updatedSprint.getId());
        sprint1.setTasks(updatedSprint.getTasks());
        sprint1.setDescription(updatedSprint.getDescription());
        sprint1.setEnddate(updatedSprint.getEnddate());
        sprint1.setStartdate(updatedSprint.getStartdate());
        sprint1.setReleases(updatedSprint.getReleases());
        return sprintRepository.save(sprint1);

    }

    @Override
    public List<Sprint> findAll() {
        return sprintRepository.findAll();
    }
}
