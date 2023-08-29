package Agile.demo.Service;

import Agile.demo.Entities.Task;
import Agile.demo.Repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;
    @Autowired
    private NotifService notificationService;


    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }
    @Override
    public Task createdTask(Task task) {
        Task createdTask = taskRepository.save(task);

        notificationService.createTaskNotification(createdTask, "créée");

        return createdTask;
    }

    @Override
    public Task findById(Integer id) {
        return taskRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Task not found"));
    }

    @Override
    public void delete(Integer id) {
        Task task=taskRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Task not found"));
        taskRepository.delete(task);

    }

    @Override
    public Task update(Integer id, Task updatedTask) {
        Task task1 = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found"));
        task1.setId(updatedTask.getId());
        task1.setDescription(updatedTask.getDescription());
        task1.setSprint(updatedTask.getSprint());
        task1.setStatut(updatedTask.getStatut());
        task1.setPriority(updatedTask.getPriority());
        notificationService.createTaskNotification(updatedTask,"mise à jour");
        return taskRepository.save(task1);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}
