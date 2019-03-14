package eci.ieti.taskplanner.model;

import java.util.Objects;

public class Task {

    private String id;
    private long dueDate;
    private User responsible;
    private State state;
    private String description;

    public Task() {
    }

    public Task(long dueDate, User responsible, State state, String description) {
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.state = state;
        this.description = description;
        this.id = String.valueOf(this.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dueDate, responsible, state, description);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
