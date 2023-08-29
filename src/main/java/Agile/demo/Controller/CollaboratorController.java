package Agile.demo.Controller;

import Agile.demo.Entities.Collaborator;
import Agile.demo.Service.CollaboratorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/collaborators")
public class CollaboratorController {
    private CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }
    @PostMapping("")
    public Collaborator create(@RequestBody() Collaborator collaborator) {
        return collaboratorService.create(collaborator);
    }
    @GetMapping(path="find/{id}")
    public Collaborator findById(@PathVariable Long id) {
        return collaboratorService.findById(id);
    }
    @DeleteMapping(path="delete/{id}")
    public void delete(@PathVariable Long id) {
        collaboratorService.delete(id);
    }
    @PutMapping(path="update/{id}")
    public Collaborator update(@PathVariable Long id,@RequestBody Collaborator updatedCollaborator) {
        return collaboratorService.update(id, updatedCollaborator);
    }
    @GetMapping("/all")
    public List<Collaborator> findAll() {
        return collaboratorService.findAll();
    }
}
