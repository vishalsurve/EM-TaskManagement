/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.controller;

import com.em.emtaskmanagement.dao.TaskDAOImpl;
import com.em.emtaskmanagement.dao.UserDAOImpl;
import com.em.emtaskmanagement.dao.WorkspaceDAOImpl;
import com.em.emtaskmanagement.model.JsonResponse;
import com.em.emtaskmanagement.model.Task;
import com.em.emtaskmanagement.model.Workspace;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vishal
 */
@Controller
public class TaskController {

    @Resource
    private WorkspaceDAOImpl workspaceDAOImpl;
    @Resource
    private UserDAOImpl userDAOImpl;
    @Resource
    private TaskDAOImpl taskDAOImpl;

    @RequestMapping(value = "workspacename/createTask")
    public String createTask() {

        return "savetask";
    }

    @RequestMapping(value = "addTask", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse listWorkspace(Task task, HttpServletRequest request, BindingResult result) {


        HttpSession session = request.getSession(true);
        Object attribute = session.getAttribute("UserName");
        String username = attribute.toString();
        Object workspacename = session.getAttribute("workspacename");
        String workspaceName = workspacename.toString();

        Workspace workspaceByName = workspaceDAOImpl.getWorkspaceByName(workspaceName);
        int userid = userDAOImpl.findUserIdbyEmail(username);
        task.setOwnerid(userid);
        task.setWorkspace(workspaceByName);

        taskDAOImpl.saveTask(task);

        JsonResponse res = new JsonResponse();
        List<String> taskList = taskDAOImpl.taskList();

        ValidationUtils.rejectIfEmpty(result, "taskname", "Task Name can not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "startdate", "Start Date can not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "enddate", "End Date can not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "priority", "Priority can not be empty.");
        if (!result.hasErrors()) {
            res.setResult(taskList);
            res.setStatus("SUCCESS");
        } else {
            res.setStatus("FAIL");
            res.setResult(result.getAllErrors());
        }
        return res;
    }

    @RequestMapping(value = "/tasklist", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse listTask() {
        JsonResponse res = new JsonResponse();
        List<String> taskList = taskDAOImpl.taskList();
        if (taskDAOImpl.taskList().size() > 0) //        if (!result.hasErrors()) {
        {
            res.setResult(taskList);
            res.setStatus("SUCCESS");
        } else {
            res.setStatus("FAIL");
        }
        return res;
    }
}
