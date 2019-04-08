package eci.ieti.taskplanner.services;

import eci.ieti.taskplanner.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> geTasksList();

    Task getTaskById(String id) throws TaskPlannerException;

    List<Task> getTasksByUserId(String userId);

    Task assignTaskToUser(String taskId, String username) throws TaskPlannerException;

    void removeTask(String taskId);

    Task updateTask(Task task);

    Task createTask(Task task);

}