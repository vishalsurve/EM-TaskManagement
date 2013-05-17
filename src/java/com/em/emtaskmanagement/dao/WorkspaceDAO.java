/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.Workspace;
import java.util.List;

/**
 *
 * @author vishal
 */
public interface WorkspaceDAO {

    public int getWorkspaceIdByName(String name);

    public void saveWorkspace(Workspace workspace);

    public void addUserList(int workspaceid, List UserId);
}
