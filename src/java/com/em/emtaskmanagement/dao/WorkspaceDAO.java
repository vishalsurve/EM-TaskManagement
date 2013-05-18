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

    public Workspace getWorkspaceByName(String workspacename);

    public void saveWorkspace(Workspace workspace);

    public List<String> workspaceList();

    public void addUserList(int workspaceid, List UserId);

    public List<String> showActiveWorkspace();

    public void deleteWorkspace(int workspaceid);

    public void updateWorkspace(int workspaceid, String workspacename);
}
