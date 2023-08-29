package Agile.demo.Controller;

import Agile.demo.Entities.UserStory;
import Agile.demo.Service.UserStoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userstories")
public class UserStoryController {
    private UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }
    @PostMapping("")
    public UserStory create(@RequestBody() UserStory userStory) {
        return userStoryService.create(userStory);
    }
    @GetMapping(path="{id}")
    public UserStory findById(@PathVariable Integer id) {
        return userStoryService.findById(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userStoryService.delete(id);
    }
    @PutMapping("/update/{id}")
    public UserStory update(@PathVariable Integer id,@RequestBody UserStory updatedUserStory) {
        return userStoryService.update(id, updatedUserStory);
    }
    @GetMapping("/all")
    public List<UserStory> findAll() {
        return userStoryService.findAll();
    }
}
