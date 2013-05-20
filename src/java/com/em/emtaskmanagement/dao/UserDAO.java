/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.User;
import java.util.List;

/**
 *
 * @author vishal
 */
public interface UserDAO {

    public int findUserIdbyEmail(String email);

    public int login(String name, String password);

    public List getUserIdByName(String[] userlist);

    public void saveUser(User user);

    public List<String> getAllUser();

    public List<String> getUserByWorkspace(int workspaceId);
}
