package eci.ieti.taskplanner.services;

import eci.ieti.taskplanner.Persistence.Persistence;
import eci.ieti.taskplanner.model.Task;
import eci.ieti.taskplanner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceStub implements TaskService {

    @Autowired
    private Persistence persistence;

    @Override
    public List<Task> geTasksList() {
        return persistence.getTasks();
    }

    @Override
    public Task getTaskById(String id) throws TaskPlannerException {
        return persistence.getTask(id);
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return persistence.getTasksByUsername(userId);
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) throws TaskPlannerException {
        return persistence.assignTaskToUser(taskId, user);
    }

    @Override
    public void removeTask(String taskId) {
        persistence.removeTask(taskId);
    }

    @Override
    public Task updateTask(Task task) {
        return persistence.updateTask(task);
    }

    @Override
    public Task createTask(Task task) {
        return persistence.saveTask(task);
    }
}
