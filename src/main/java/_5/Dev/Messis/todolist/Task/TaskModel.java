package _5.Dev.Messis.todolist.Task;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
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

    private UUID id_User;
}