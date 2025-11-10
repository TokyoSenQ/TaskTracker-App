package jeka.tsen.tasktracker.dto;

import jeka.tsen.tasktracker.enums.TaskPriority;
import jeka.tsen.tasktracker.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto (
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
){
}
