/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieti.TaskPlanner.model.services;

import com.ieti.TaskPlanner.model.entities.Task;
import com.ieti.TaskPlanner.model.entities.User;
import java.util.List;

/**
 *
 * @author npatino
 */
public interface TaskServices {
    List<Task> geAll();
    
        List<Task> getTasksList();
        
        Task getById(String id);
        
        List<Task> getByUserId(String userId);
        
        Task assignTaskToUser(String taskId, User user);
        
        void remove(String taskId);
        
        Task update(Task task);
    
        void removeTask(String taskId);
        
        Task createTask(Task task);
        
        Task updateTask(Task task);
        List<Task> getTasksByUserId(String userId);
}
