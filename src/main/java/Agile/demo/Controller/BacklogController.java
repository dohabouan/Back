package Agile.demo.Controller;

import Agile.demo.Entities.Backlog;
import Agile.demo.Service.BacklogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Backlogs")
public class BacklogController {
    private BacklogService backlogService;

    public BacklogController(BacklogService backlogService) {
        this.backlogService = backlogService;
    }
    @PostMapping("")

    public Backlog create(@RequestBody() Backlog backlog) {
        return backlogService.create(backlog);
    }
    @GetMapping(path="/find/{id}")
    public Backlog findById(@PathVariable Integer id) {
        return backlogService.findById(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable Integer id) {
        backlogService.delete(id);
    }
    @PutMapping(path="/update/{id}")
    public Backlog update(@PathVariable Integer id,@RequestBody Backlog updatedBacklog) {
        return backlogService.update(id, updatedBacklog);
    }
    @GetMapping("/all")
    public List<Backlog> findAll() {
        return backlogService.findAll();
    }
}
