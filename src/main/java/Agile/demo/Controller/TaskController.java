package Agile.demo.Controller;

import Agile.demo.Entities.Task;
import Agile.demo.Repository.TaskRepository;
import Agile.demo.Service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("")

    public Task create(@RequestBody() Task task) {
        return taskService.create(task);
    }
    @GetMapping(path="{id}")
    public Task findById(@PathVariable Integer id) {
        return taskService.findById(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable Integer id) {
        taskService.delete(id);
    }
    @PutMapping("/update/{id}")
    public Task update(@PathVariable Integer id,@RequestBody Task updatedTask) {
        return taskService.update(id, updatedTask);
    }
    @GetMapping("/all")
    public List<Task> findAll() {
        return taskService.findAll();
    }
}
