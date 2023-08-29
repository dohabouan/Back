package Agile.demo.Service;

import Agile.demo.Entities.Backlog;
import Agile.demo.Entities.UserStory;

import java.util.List;

public interface UserStoryService {

    UserStory create (UserStory userStory);
    UserStory findById(Integer id);
    void delete(Integer id);
    UserStory update( Integer id,UserStory updatedUserStory);
    List<UserStory> findAll();
}
