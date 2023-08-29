package Agile.demo.Controller;

import Agile.demo.Entities.Sprint;
import Agile.demo.Service.SprintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sprints")
public class SprintController {
    private SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @PostMapping("")
    public Sprint create(@RequestBody() Sprint sprint) {
        return sprintService.create(sprint);
    }
    @GetMapping(path="{id}")
    public Sprint findById(@PathVariable Integer id) {
        return sprintService.findById(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable Integer id) {
        sprintService.delete(id);
    }
    @PutMapping("/update/{id}")
    public Sprint update(@PathVariable Integer id,@RequestBody Sprint updatedSprint) {
        return sprintService.update(id, updatedSprint);
    }
    @GetMapping("/all")
    public List<Sprint> findAll() {
        return sprintService.findAll();
    }
}
