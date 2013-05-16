/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.controller;

import com.em.emtaskmanagement.dao.WorkspaceDAOImpl;
import com.em.emtaskmanagement.model.Workspace;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Vishal
 */
@Controller
public class WorkspaceController {

    @Autowired
    private WorkspaceDAOImpl workspaceDAOImpl;

    @RequestMapping(value = "/workspace")
    public String workspace() {
        return "saveworkspace";
    }

    @RequestMapping(value = "/addworkspace")
    public void addWorkspace(Workspace workspace, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Object attribute = session.getAttribute("UserName");
        String username = attribute.toString();
        
        
    }
}
