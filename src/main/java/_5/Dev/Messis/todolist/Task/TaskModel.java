package _5.Dev.Messis.todolist.Task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tb_task")
@Data
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(length = 120)
    private String tittle;

    private String description;
    private String priority;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime endedAt;
    
    // validar id do usuário
    //@Column(nullable = false)
    private UUID id_User;
}