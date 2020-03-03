/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieti.TaskPlanner.model.repository;

import com.ieti.TaskPlanner.model.entities.Task;
import com.ieti.TaskPlanner.model.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author npatino
 */
public interface TaskRepository extends CrudRepository<Task, Integer>{
    List<Task> getAll();

    Task getById(String id);

    List<Task> getByUserId(String userId);

    Task assignTaskToUser(String taskId, User user);

    Task create(Task task);

    void remove(String taskId);

    Task update(Task task);
    
}
