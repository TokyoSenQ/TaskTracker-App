package jeka.tsen.tasktracker.mappers.impl;

import jeka.tsen.tasktracker.dto.TaskDto;
import jeka.tsen.tasktracker.enums.TaskPriority;
import jeka.tsen.tasktracker.enums.TaskStatus;
import jeka.tsen.tasktracker.mappers.TaskMapper;
import jeka.tsen.tasktracker.model.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) {
        return new Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.priority(),
                taskDto.status(),
                null,
                null,
                null
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
