package eci.ieti.taskplanner.model;

import java.util.Date;

public class Task {

    public final static String READY = "Ready";
    public final static String IN_PROGRESS = "In Progress";
    public final static String DONE = "Done";

    private String id;
    private Date dueDate;
    private User responsible;
    private String status;
    private String description;

    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
