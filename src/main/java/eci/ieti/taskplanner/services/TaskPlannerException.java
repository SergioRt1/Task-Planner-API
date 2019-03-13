package eci.ieti.taskplanner.services;

public class TaskPlannerException extends Exception {

    public final static String NOT_FOUND="The element does not exists";

    public TaskPlannerException(String message) {
        super(message);
    }


}
