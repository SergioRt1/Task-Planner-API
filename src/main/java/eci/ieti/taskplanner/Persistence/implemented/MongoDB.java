package eci.ieti.taskplanner.Persistence.implemented;

import eci.ieti.taskplanner.Persistence.Persistence;
import eci.ieti.taskplanner.Repositories.TaskRepository;
import eci.ieti.taskplanner.Repositories.UserRepository;
import eci.ieti.taskplanner.model.Task;
import eci.ieti.taskplanner.model.User;
import eci.ieti.taskplanner.services.TaskPlannerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoDB implements Persistence {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByUsername(String username) {
        return taskRepository.findAllByOwner(username);
    }

    @Override
    public Task getTask(String id) throws TaskPlannerException {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent())
            return task.get();
        throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void removeTask(String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) throws TaskPlannerException {
        Task task = getTask(taskId);
        task.setResponsible(user);
        return updateTask(task);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String username) throws TaskPlannerException {
        Optional<User> user = userRepository.findById(username);
        if(user.isPresent())
            return user.get();
        throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
    }

    @Override
    public User saveUser(User user) throws TaskPlannerException {
        if(userRepository.existsById(user.getUsername())) throw new TaskPlannerException(TaskPlannerException.USER_ALREADY_EXISTS);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUser(String username) {
        userRepository.deleteById(username);
    }
}
