/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieti.TaskPlanner.model.controllers;

import com.ieti.TaskPlanner.model.entities.Task;
import com.ieti.TaskPlanner.model.entities.User;
import com.ieti.TaskPlanner.model.services.TaskServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author npatino
 */
public class TaskController {
      @Autowired
    private TaskServices taskService;
    @Autowired

    @RequestMapping(value = "/v1/tasks", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getTasksList() {
        List<Task> tasks = taskService.getTasksList();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @RequestMapping(value = "/v1/tasks/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<Task> getById(@PathVariable String taskId) {
        Task task = taskService.getById(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @RequestMapping(value = "/v1/users/{userId}/tasks", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable String userId) {
        List<Task> tasks = taskService.getTasksByUserId(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @RequestMapping(value = "/v1/users/tasks/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity<Task> putTaskToUser(@PathVariable String taskId, @RequestBody User user) {
        Task task = taskService.assignTaskToUser(taskId, user);
        return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/v1/tasks", method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task taskCreated = taskService.createTask(task);
        return new ResponseEntity<>(taskCreated, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/v1/tasks/{taskId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeTask(@PathVariable String taskId) {
        taskService.removeTask(taskId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/v1/tasks", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        Task taskUpdated = taskService.updateTask(task);
        return new ResponseEntity<>(taskUpdated, HttpStatus.ACCEPTED);
    }
 
    
    
}
