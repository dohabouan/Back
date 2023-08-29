package Agile.demo.Service;

import Agile.demo.Entities.Backlog;
import Agile.demo.Entities.Task;

import java.util.List;

public interface TaskService {
    Task create (Task task);
    Task findById(Integer id);
    void delete(Integer id);
    Task update( Integer id,Task updatedTask);
    List<Task> findAll();
    public Task createdTask(Task task);
}
