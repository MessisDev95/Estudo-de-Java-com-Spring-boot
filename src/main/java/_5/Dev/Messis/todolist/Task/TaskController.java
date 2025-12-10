package _5.Dev.Messis.todolist.Task;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired // Dependency injection of the task repository
    private ITaskRepository taskRepository;
    
    @RequestMapping("/") // Maps HTTP requests to /tasks/ to this method
    public TaskModel create(@RequestBody TaskModel taskModel) {
        var task = this.taskRepository.save(taskModel);
        return task;
    }
}
