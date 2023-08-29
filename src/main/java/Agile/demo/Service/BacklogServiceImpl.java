package Agile.demo.Service;

import Agile.demo.Entities.Backlog;
import Agile.demo.Repository.BacklogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogServiceImpl implements BacklogService{
    private BacklogRepository backlogRepository;

    public BacklogServiceImpl(BacklogRepository backlogRepository) {
        this.backlogRepository = backlogRepository;
    }

    @Override
    public Backlog create(Backlog backlog) {
        return backlogRepository.save(backlog);
    }

    @Override
    public Backlog findById(Integer id) {
        return backlogRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Backlog not found"));
    }

    @Override
    public void delete(Integer id) {
        Backlog backlog=backlogRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Backlog not found"));
        backlogRepository.delete(backlog);


    }

    @Override
    public Backlog update(Integer id, Backlog updatedBacklog) {
        Backlog backlog1=backlogRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Backlog not found"));
        backlog1.setId(updatedBacklog.getId());
        backlog1.setPriority(updatedBacklog.getPriority());
        backlog1.setDescription(updatedBacklog.getDescription());
        backlog1.setUserStories(updatedBacklog.getUserStories());
        return backlogRepository.save(backlog1);
    }

    @Override
    public List<Backlog> findAll() {
        return backlogRepository.findAll();
    }
}
