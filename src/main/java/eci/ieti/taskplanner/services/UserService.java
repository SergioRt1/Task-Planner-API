package eci.ieti.taskplanner.services;

import eci.ieti.taskplanner.model.User;

import java.util.List;


public interface UserService {

    List<User> getUsersList();

    User getUser(String username) throws TaskPlannerException;

    User createUser(User user) throws TaskPlannerException;

    User updateUser(User user);

    void removeUser(String userId);

}