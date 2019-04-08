package eci.ieti.taskplanner.Persistence.implemented;

import eci.ieti.taskplanner.Persistence.Persistence;
import eci.ieti.taskplanner.model.State;
import eci.ieti.taskplanner.model.Task;
import eci.ieti.taskplanner.model.User;
import eci.ieti.taskplanner.services.TaskPlannerException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class InMemory implements Persistence {

    private List<Task> tasks;
    private Map<String, Task> taskById;

    private List<User> users;
    private Map<String, User> usersById;

    public InMemory() {
        this.tasks = new ArrayList<>();
        this.taskById = new HashMap<>();

        this.users = new ArrayList<>();
        this.usersById = new HashMap<>();
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public List<Task> getTasksByUsername(String username) {
        List<Task> list = new ArrayList<>();
        for (Task task : tasks)
            if (task.getOwner().equals(username))
                list.add(task);
        return list;
    }

    @Override
    public Task getTask(String id) throws TaskPlannerException{
        if (taskById.containsKey(id))
            return taskById.get(id);
        throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
    }

    @Override
    public Task saveTask(Task task) {
        task.setId(String.valueOf(task.hashCode()));
        tasks.add(task);
        taskById.put(task.getId(), task);
        return task;
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
    public void removeTask(String id) {
        for (int i = 0; i < tasks.size(); i++)
            if (tasks.get(i).getId().equals(id)) {
                tasks.remove(i);
                break;
            }
        taskById.remove(id);
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) throws TaskPlannerException {
        Task task = getTask(taskId);
        task.setResponsible(user);
        return this.updateTask(task);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(String username) throws TaskPlannerException {
        if(usersById.containsKey(username))
            return usersById.get(username);
        else throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
    }

    @Override
    public User saveUser(User user) throws TaskPlannerException {
        String userId = user.getUsername();
        if(usersById.containsKey(userId)) throw new TaskPlannerException(TaskPlannerException.USER_ALREADY_EXISTS);
        usersById.put(user.getUsername(),user);
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(user.getUsername())){
                users.set(i,user);
            }
        }
        usersById.replace(user.getUsername(),user);
        return user;
    }

    @Override
    public void removeUser(String username) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(username)){
                users.remove(i);
                break;
            }
        }
        usersById.remove(username);
    }
}
