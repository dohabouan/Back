package Agile.demo.Controller;

import Agile.demo.Entities.Project;
import Agile.demo.Service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("")

    public Project create(@RequestBody() Project project) {
        return projectService.create(project);
    }
    @GetMapping(path="/find/{id}")
    public Project findById(@PathVariable Integer id) {
        return projectService.findById(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable Integer id) {
        projectService.delete(id);
    }
    @PutMapping(path="/update/{id}")
    public Project update(@PathVariable() Integer id,@RequestBody() Project updatedProjet) {
        return projectService.update(id, updatedProjet);
    }
    @GetMapping("/all")
    public List<Project> findAll() {
        return projectService.findAll();
    }
}



