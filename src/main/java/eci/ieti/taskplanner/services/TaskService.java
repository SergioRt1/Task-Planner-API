package eci.ieti.taskplanner.services;

import eci.ieti.taskplanner.model.Task;
import eci.ieti.taskplanner.model.User;

import java.util.List;

public interface TaskService {

    List<Task> geTasksList();

    Task getTaskById(String id) throws TaskPlannerException;

    List<Task> getTasksByUserId(String userId);

    Task assignTaskToUser(String taskId, User user);

    void removeTask(String taskId);

    Task updateTask(Task task);

}