package _5.Dev.Messis.todolist.Task;


import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        System.out.println(request.getAttribute("idUser"));

        var idUser = request.getAttribute("idUser");
        taskModel.setId_User((UUID) idUser);

        var currentDate = LocalDateTime.now();
        if (currentDate.isAfter(taskModel.getCreatedAt()) || currentDate.isAfter(taskModel.getEndedAt())) {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de criação / data de finalização não pode ser no passado.");

        }

        if (taskModel.getCreatedAt().isAfter(taskModel.getEndedAt())) {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data de finalização não pode ser anterior à data de criação.");

        }
    
        
        // faltou um pedacinho
        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
}
