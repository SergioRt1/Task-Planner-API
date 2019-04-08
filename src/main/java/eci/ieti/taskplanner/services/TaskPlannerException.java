package eci.ieti.taskplanner.services;

public class TaskPlannerException extends Exception {

    public static final String NOT_FOUND = "The element does not exists";
    public static final String USER_ALREADY_EXISTS = "Username already exists";
    public static final String UNEXPECTED_ERROR = "An unexpected error happened";

    public TaskPlannerException(String message) {
        super(message);
    }


}
