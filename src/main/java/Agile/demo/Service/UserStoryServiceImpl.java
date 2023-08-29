package Agile.demo.Service;

import Agile.demo.Entities.UserStory;
import Agile.demo.Repository.UserStoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryServiceImpl implements UserStoryService{
    private UserStoryRepository userStoryRepository;

    public UserStoryServiceImpl(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    @Override
    public UserStory create(UserStory userStory) {
        return userStoryRepository.save(userStory);
    }

    @Override
    public UserStory findById(Integer id) {
        return userStoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("UserStory not found"));
    }

    @Override
    public void delete(Integer id) {
        UserStory userStory =userStoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("UserStory not found"));
        userStoryRepository.delete(userStory);
    }

    @Override
    public UserStory update(Integer id, UserStory updatedUserStory) {
        UserStory userStory1 =userStoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("UserStory not found"));
        userStory1.setId(updatedUserStory.getId());
        userStory1.setDescription(updatedUserStory.getDescription());
        userStory1.setTeam(updatedUserStory.getTeam());
        userStory1.setSprints(updatedUserStory.getSprints());
        userStory1.setBacklog(updatedUserStory.getBacklog());
        return userStoryRepository.save(userStory1);

    }

    @Override
    public List<UserStory> findAll() {
        return userStoryRepository.findAll();
    }
}
