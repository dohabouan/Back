package Agile.demo.Controller;



import Agile.demo.Entities.Release;
import Agile.demo.Service.ReleaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/releases")
public class ReleaseController {
    private ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }
    @PostMapping("")
    public Release create(@RequestBody() Release release) {
        return releaseService.create(release);
    }
    @GetMapping(path="{id}")
    public Release findById(@PathVariable Integer id) {
        return releaseService.findById(id);
    }
    @DeleteMapping(path="{id}")
    public void delete(@PathVariable Integer id) {
        releaseService.delete(id);
    }
    @PutMapping(path="/update/{id}")
    public Release update(@PathVariable Integer id,@RequestBody Release updatedRelease) {
        return releaseService.update(id, updatedRelease);
    }
    @GetMapping("/all")
    public List<Release> findAll() {
        return releaseService.findAll();
    }
}
