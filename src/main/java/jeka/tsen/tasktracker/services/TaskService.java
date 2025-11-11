package jeka.tsen.tasktracker.services;

import jeka.tsen.tasktracker.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface TaskService {
    List<Task> listTasks(UUID taskListId);
    Task createTask(UUID taskListId, Task Task);
    Optional<Task> getTask(UUID taskListId, UUID taskId);
    Task updateTask (UUID taskListId, UUID taskId, Task task);
    void deleteTask(UUID taskListId, UUID taskId);
}
