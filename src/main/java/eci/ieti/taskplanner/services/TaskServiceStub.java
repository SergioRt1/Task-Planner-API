package eci.ieti.taskplanner.services;

import eci.ieti.taskplanner.model.State;
import eci.ieti.taskplanner.model.Task;
import eci.ieti.taskplanner.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceStub implements TaskService {

    private List<Task> tasks;
    private Map<String, Task> taskById;

    public TaskServiceStub() {
        tasks = new ArrayList<>();
        taskById = new HashMap<>();
        User user1 = new User("Sergio Rodriguez", "sergio200035@gmail.com", "SergioRt", "1234");
        User user2 = new User("Diana Martinez", "diana@gmail.com", "Diana99", "1234");
        createTask(new Task(1552602173033L, user1, State.In_Progress, "Task Example"));
        createTask(new Task(1552602856887L, user1, State.Completed, "Task Done"));
        createTask(new Task(1552603534412L, user2, State.Ready, "Task Ready"));
    }

    @Override
    public List<Task> geTasksList() {
        return tasks;
    }

    @Override
    public Task getTaskById(String id) throws TaskPlannerException {
        if (taskById.containsKey(id))
            return taskById.get(id);
        throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        List<Task> list = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++)
            if (tasks.get(i).getResponsible().getUsername().equals(userId))
                list.add(tasks.get(i));
        return list;
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) throws TaskPlannerException {
        Task task = getTaskById(taskId);
        task.setResponsible(user);
        return this.updateTask(task);
    }

    @Override
    public void removeTask(String taskId) {
        for (int i = 0; i < tasks.size(); i++)
            if (tasks.get(i).getId().equals(taskId)) {
                tasks.remove(i);
                break;
            }
        taskById.remove(taskId);
    }

    @Override
    public Task updateTask(Task task) {
        for (int i = 0; i < tasks.size(); i++)
            if (task.getId().equals(tasks.get(i).getId()))
                tasks.set(i, task);
        taskById.replace(task.getId(), task);
        return task;
    }

    @Override
    public Task createTask(Task task) {
        tasks.add(task);
        taskById.put(task.getId(), task);
        return task;
    }
}
