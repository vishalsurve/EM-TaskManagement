/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.controller;

import com.em.emtaskmanagement.dao.UserDAOImpl;
import com.em.emtaskmanagement.dao.WorkspaceDAOImpl;
import com.em.emtaskmanagement.model.JsonResponse;
import com.em.emtaskmanagement.model.User;
import com.em.emtaskmanagement.model.Workspace;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vishal
 */
@Controller
public class WorkspaceController {

    @Resource
    private WorkspaceDAOImpl workspaceDAOImpl;
    @Resource
    private UserDAOImpl userDAOImpl;

    @RequestMapping(value = "/workspace")
    public String workspace() {
        return "saveworkspace";
    }

    @RequestMapping(value = "/addworkspace", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse listWorkspace(@ModelAttribute(value = "workspacename") Workspace workspace, HttpServletRequest request, BindingResult result) {

        HttpSession session = request.getSession(true);
        Object attribute = session.getAttribute("UserName");
        String username = attribute.toString();
        int userid = userDAOImpl.findUserIdbyEmail(username);
        workspace.setOwnerid(userid);
        workspaceDAOImpl.saveWorkspace(workspace);

        JsonResponse res = new JsonResponse();
        List<String> workspaceList = workspaceDAOImpl.workspaceList();


        ValidationUtils.rejectIfEmpty(result, "workspacename", "Name can not be empty.");
        if (!result.hasErrors()) {
            res.setResult(workspaceList);
            res.setStatus("SUCCESS");
        } else {
            res.setStatus("FAIL");
            res.setResult(result.getAllErrors());
        }
        return res;

    }

    @RequestMapping(value = "/workspacelist", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse listWorkspace1() {//BindingResult result) {
        JsonResponse res = new JsonResponse();
        List<String> workspaceList = workspaceDAOImpl.workspaceList();
        if (workspaceDAOImpl.workspaceList().size() > 0) //        if (!result.hasErrors()) {
        {
            res.setResult(workspaceList);
            res.setStatus("SUCCESS");
        } else {
            res.setStatus("FAIL");
        }
        return res;
    }

    @RequestMapping(value = "workspacename/{workspacename}", method = RequestMethod.GET)
    public String getWorkspace(@PathVariable("workspacename") String workspacename, ModelMap modelMap, HttpServletRequest request) {
        
        HttpSession session = request.getSession(true);
        session.setAttribute("workspacename", request);
        List<String> allUser = userDAOImpl.getAllUser();
        modelMap.put("userList", allUser);
        modelMap.put("workspacename", workspacename);

        return "home";
    }

    @RequestMapping(value = "workspacename/adduser", method = RequestMethod.POST)
    public void addUser(HttpServletRequest request, Workspace workspace, User user) {

        String workspacename = request.getParameter("workspacename");
        String[] userlist = request.getParameterValues("userdata");

        int workspaceIdByName = workspaceDAOImpl.getWorkspaceIdByName(workspacename);
        List UserId = userDAOImpl.getUserIdByName(userlist);
        workspaceDAOImpl.addUserList(workspaceIdByName, UserId);
    }
}
