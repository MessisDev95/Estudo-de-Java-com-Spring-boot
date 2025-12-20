package _5.Dev.Messis.todolist.Task;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired // Dependency injection of the task repository
    private ITaskRepository taskRepository;
    
    @PostMapping("/") // Maps HTTP requests to /tasks/ to this method
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        System.out.println(request.getAttribute("idUser"));

        var idUser = request.getAttribute("idUser");
        taskModel.setUserId((UUID) idUser);

        var currentDate = LocalDateTime.now();
        if (currentDate.isAfter(taskModel.getCreatedAt()) || currentDate.isAfter(taskModel.getEndedAt())) {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de criação / data de finalização não pode ser no passado.");

        }

        if (taskModel.getCreatedAt().isAfter(taskModel.getEndedAt())) {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data de finalização não pode ser anterior à data de criação.");

        }
    
        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
    
    @GetMapping("/") // Maps HTTP GET requests to /tasks/ to this method
    public List<TaskModel> list(HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByUserId((UUID) idUser);
        return tasks;
    }
    
    @PutMapping("/{id}")
    public TaskModel update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable UUID id){
        var idUser = request.getAttribute("idUser");
        taskModel.setUserId((UUID) idUser);
        taskModel.setId(id);
        this.taskRepository.save(taskModel);
        return taskModel;

    }
}
