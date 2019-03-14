package eci.ieti.taskplanner.controller;

import eci.ieti.taskplanner.model.Task;
import eci.ieti.taskplanner.model.User;
import eci.ieti.taskplanner.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<?> getTasksHandler() {
        try {
            return new ResponseEntity<>(service.geTasksList(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskByIdHandler(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(service.getTaskById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<?> getTasksByUserIdHandler(@PathVariable("userId") String userId) {
        try {

            return new ResponseEntity<>(service.getTasksByUserId(userId), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTaskHandler(@RequestBody Task task) {
        try {
            return new ResponseEntity<>(service.createTask(task), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTaskHandler(@RequestBody Task task) {
        try {
            return new ResponseEntity<>(service.updateTask(task), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/assign/{taskId}")
    public ResponseEntity<?> assignTaskHandler(@PathVariable("taskId") String taskId, @RequestBody User user) {
        try {
            return new ResponseEntity<>(service.assignTaskToUser(taskId, user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskHandler(@PathVariable String id) {
        try {
            service.removeTask(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
