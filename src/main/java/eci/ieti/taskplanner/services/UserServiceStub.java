package eci.ieti.taskplanner.services;

import eci.ieti.taskplanner.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceStub implements UserService {

    private List<User> users;
    private Map<String, User> usersById;

    public UserServiceStub() {
        this.users = new ArrayList<>();
        this.usersById = new HashMap<>();
        try {
            this.createUser(new User("Sergio Rodriguez", "sergio200035@gmail.com", "SergioRt", "1234"));
            this.createUser(new User("Diana Martinez", "diana@gmail.com", "Diana99", "1234"));
        } catch (TaskPlannerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsersList() {
        return users;
    }

    @Override
    public User getUserById(String userId) throws TaskPlannerException {
        if(usersById.containsKey(userId))
            return usersById.get(userId);
        else throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
    }

    @Override
    public User createUser(User user) throws TaskPlannerException {
        String userId = user.getUsername();
        if(usersById.containsKey(userId))
            throw new TaskPlannerException(TaskPlannerException.USER_ALREADY_EXISTS);
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
    public void removeUser(String userId) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(userId)){
                users.remove(i);
                break;
            }
        }
        usersById.remove(userId);
    }
}
