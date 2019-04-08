package eci.ieti.taskplanner.controller;

import eci.ieti.taskplanner.model.Task;
import eci.ieti.taskplanner.services.TaskService;
import eci.ieti.taskplanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getTasksHandler() {
        try {
            return new ResponseEntity<>(taskService.geTasksList(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskByIdHandler(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<?> getTasksByUserIdHandler(@PathVariable("userId") String userId) {
        try {

            return new ResponseEntity<>(taskService.getTasksByUserId(userId), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTaskHandler(@RequestBody Task task) {
        try {
            return new ResponseEntity<>(taskService.createTask(task), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTaskHandler(@RequestBody Task task) {
        try {
            return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/assign/{taskId}")
    public ResponseEntity<?> assignTaskHandler(@PathVariable("taskId") String taskId, @RequestBody String username) {
        try {
            return new ResponseEntity<>(taskService.assignTaskToUser(taskId, username), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskHandler(@PathVariable String id) {
        try {
            taskService.removeTask(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
