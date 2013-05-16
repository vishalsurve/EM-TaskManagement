/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.User;

/**
 *
 * @author vishal
 */
public interface UserDAO {
    
    public int findUserIdbyEmail(String email);

    public int login(String name, String password);

    public void saveUser(User user);
}
