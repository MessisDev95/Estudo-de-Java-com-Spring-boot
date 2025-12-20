package _5.Dev.Messis.todolist.Task;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository provides CRUD operations for TaskModel entity with UUID as ID type
public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    List<TaskModel> findByUserId(UUID id_User);
}
