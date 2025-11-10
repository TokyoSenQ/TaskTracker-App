package jeka.tsen.tasktracker.mappers;

import jeka.tsen.tasktracker.dto.TaskListDto;
import jeka.tsen.tasktracker.model.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
