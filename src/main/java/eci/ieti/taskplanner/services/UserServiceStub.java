package eci.ieti.taskplanner.services;

import eci.ieti.taskplanner.Persistence.Persistence;
import eci.ieti.taskplanner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceStub implements UserService {

    @Autowired
    private Persistence persistence;

    @Override
    public List<User> getUsersList() {
        return persistence.getUsers();
    }

    @Override
    public User getUser(String username) throws TaskPlannerException {
        return persistence.getUser(username);
    }

    @Override
    public User createUser(User user) throws TaskPlannerException {
        return persistence.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return persistence.updateUser(user);
    }

    @Override
    public void removeUser(String userId) {
        persistence.removeUser(userId);
    }
}
