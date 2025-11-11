package jeka.tsen.tasktracker.controllers;

import jeka.tsen.tasktracker.dto.TaskDto;
import jeka.tsen.tasktracker.mappers.TaskMapper;
import jeka.tsen.tasktracker.model.Task;
import jeka.tsen.tasktracker.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;


    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id") UUID taskListId){
        return taskService.listTasks(taskListId)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }


    @PutMapping
    @Transactional
    public TaskDto createTask(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskDto taskDto
    ) {
        Task createdTask = taskService.createTask(
                taskListId,
                taskMapper.fromDto(taskDto)
                );

        return taskMapper.toDto(createdTask);
    }


    @GetMapping(path = "/{task_id}")
    public Optional<TaskDto> getTask(
            @PathVariable("task_list_id") UUID taskListId,
            @PathVariable("task_id") UUID taskId
    ) {
        return taskService.getTask(taskListId, taskId)
                .map(taskMapper::toDto);
    }


    @PutMapping(path = "/{task_id}")
    @Transactional
    public TaskDto updateTask(@PathVariable("task_list_id") UUID taskListId,
                              @PathVariable("task_id") UUID taskId,
                              @RequestBody TaskDto taskDto
    ) {

        Task updatedTask = taskService.updateTask(taskListId, taskId, taskMapper.fromDto(taskDto));
        return taskMapper.toDto(updatedTask);

    }


    @DeleteMapping(path = "/{task_id}")
    @Transactional
    public void deleteTask(@PathVariable("task_list_id") UUID taskListId,
                           @PathVariable("task_id") UUID taskId) {

        taskService.deleteTask(taskListId, taskId);
    }




}
