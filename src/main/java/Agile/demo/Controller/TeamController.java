package Agile.demo.Controller;

import Agile.demo.Entities.Team;
import Agile.demo.Service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/teams")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @PostMapping("")
    public Team create(@RequestBody() Team team) {
        return teamService.create(team);
    }
    @GetMapping(path="{id}")
    public Team findById(@PathVariable Integer id) {
        return teamService.findById(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable Integer id) {
        teamService.delete(id);
    }
    @PutMapping("/update/{id}")
    public Team update(@PathVariable Integer id,@RequestBody() Team updatedTeam) {
        return teamService.update(id, updatedTeam);
    }
    @GetMapping("/all")
    public List<Team> findAll() {
        return teamService.findAll();
    }
}
