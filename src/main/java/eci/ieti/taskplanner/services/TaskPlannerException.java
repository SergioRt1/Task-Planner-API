package eci.ieti.taskplanner.services;

public class TaskPlannerException extends Exception {

    public final static String NOT_FOUND = "The element does not exists";
    public final static String USER_ALREADY_EXISTS = "Username already exists";

    public TaskPlannerException(String message) {
        super(message);
    }


}
