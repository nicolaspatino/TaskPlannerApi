/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ieti.TaskPlanner.model.services;

import com.ieti.TaskPlanner.model.entities.User;
import java.util.List;

/**
 *
 * @author npatino
 */
public interface UserServices {
   List<User> getAll();
    
    User getById(String userId);
    
    User create(User user);
    
    User update(User user);
    
    void remove(String userId);
    
}
