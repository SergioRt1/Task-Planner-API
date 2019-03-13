package eci.ieti.taskplanner.controller;

import eci.ieti.taskplanner.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;


public class TaskController {

    @Autowired
    private TaskService service;

}
