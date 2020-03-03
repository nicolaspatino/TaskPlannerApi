/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieti.TaskPlanner.model.services.impl;

import com.ieti.TaskPlanner.model.entities.Task;
import com.ieti.TaskPlanner.model.entities.User;
import com.ieti.TaskPlanner.model.repository.TaskRepository;
import com.ieti.TaskPlanner.model.services.TaskServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author npatino
 */
public class TaskServiceImpl implements TaskServices{
    @Autowired
    private TaskRepository taskRepository;
	
    @Override
    public List<Task> getTasksList() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task getById(String taskId) {
    	return taskRepository.getById(taskId); 
    	
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        
        return null;
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {

    	Task newTask =taskRepository.getById(taskId);
    	newTask.setResponsible(user);
    	taskRepository.save(newTask);
        return newTask;
    }

    @Override
    public Task createTask(Task task) {
        int local = (int) (taskRepository.count()+1);
    	task.setTaskId(Integer.toString(local));   	
        return taskRepository.save(task);
    }

    @Override
    public void removeTask(String taskId) {

    	taskRepository.deleteById(Integer.parseInt(taskId));
    }

    @Override
    public Task updateTask(Task task) {

    	taskRepository.save(task);
        return task;
    }

    @Override
    public List<Task> geAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public List<Task> getByUserId(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void remove(String taskId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Task update(Task task) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
