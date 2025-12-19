package _5.Dev.Messis.todolist.Task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired // Dependency injection of the task repository
    private ITaskRepository taskRepository;
    
    @RequestMapping("/") // Maps HTTP requests to /tasks/ to this method
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        System.out.println(request.getAttribute("idUser"));
        var idUser = request.getAttribute("idUser");
        taskModel.setId_User((UUID) idUser);
        var task = this.taskRepository.save(taskModel);
        return task;
    }
}
