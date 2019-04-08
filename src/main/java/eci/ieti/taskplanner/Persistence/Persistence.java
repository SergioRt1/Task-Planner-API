package eci.ieti.taskplanner.Persistence;

import eci.ieti.taskplanner.model.Task;
import eci.ieti.taskplanner.model.User;
import eci.ieti.taskplanner.services.TaskPlannerException;

import java.util.List;

public interface Persistence {

    List<Task> getTasks();

    List<Task> getTasksByUsername(String username);

    Task getTask(String id) throws TaskPlannerException;

    Task saveTask(Task task);

    Task updateTask(Task task);

    void removeTask(String id);

    Task assignTaskToUser(String taskId, String username) throws TaskPlannerException;

    List<User> getUsers();

    User getUser(String username) throws TaskPlannerException;

    User saveUser(User user) throws TaskPlannerException;

    User updateUser(User user);

    void removeUser(String username);

}
