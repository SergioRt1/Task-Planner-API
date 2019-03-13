package eci.ieti.taskplanner.services;

import eci.ieti.taskplanner.model.Task;
import eci.ieti.taskplanner.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceStub implements TaskService {

    List<Task> tasks;
    Map<String, Task> taskById;

    public TaskServiceStub() {
        tasks = new ArrayList<>();
    }

    @Override
    public List<Task> geTasksList() {
        return  tasks;
    }

    @Override
    public Task getTaskById(String id) throws TaskPlannerException {
        if(taskById.containsKey(id))
            return taskById.get(id);
        throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return null;
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        return null;
    }

    @Override
    public void removeTask(String taskId) {

    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }
}
