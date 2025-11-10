package jeka.tsen.tasktracker.mappers;

import jeka.tsen.tasktracker.dto.TaskDto;
import jeka.tsen.tasktracker.model.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
