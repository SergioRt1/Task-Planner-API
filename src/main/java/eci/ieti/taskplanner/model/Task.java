package eci.ieti.taskplanner.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Task {

    @Id
    private String id;

    private String owner;
    private long dueDate;
    private User responsible;
    private State state;
    private String description;

    public Task() {
    }

    public Task(long dueDate, User responsible, State state, String description, String owner) {
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.state = state;
        this.description = description;
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dueDate, responsible, state, description, owner);
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
