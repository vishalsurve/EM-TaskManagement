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
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse addTask(Task task, HttpServletRequest request, BindingResult result) {

        ValidationUtils.rejectIfEmpty(result, "taskname", "Task Name can not be empty.");
        ValidationUtils.rejectIfEmpty(result, "startdate", "Start Date can not be empty.");
        ValidationUtils.rejectIfEmpty(result, "enddate", "End Date can not be empty.");
        ValidationUtils.rejectIfEmpty(result, "priority", "Priority can not be empty.");

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
        if (taskList.size() > 0) {
            res.setResult(taskList);
            res.setStatus("SUCCESS");
        } else {
            res.setStatus("FAIL");
        }
        return res;
    }

    @RequestMapping(value = "/assignedbyme", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse assignedByMe(HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("UserName");
        int userid = userDAOImpl.findUserIdbyEmail(username);

        JsonResponse res = new JsonResponse();
        List<String> taskname = taskDAOImpl.taskAssignedByMe(userid);
        if (taskname.size() > 0) {
            res.setResult(taskname);
            res.setStatus("SUCCESS");
        } else {
            res.setStatus("FAIL");
        }
        return res;
    }

    @RequestMapping(value = "/assignedtome", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse assignedToMe(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("UserName");
        int userid = userDAOImpl.findUserIdbyEmail(username);

        JsonResponse res = new JsonResponse();
        List<String> taskname = taskDAOImpl.taskAssignedToMe(userid);
        if (taskname.size() > 0) {
            res.setResult(taskname);
            res.setStatus("SUCCESS");
        } else {
            res.setStatus("FAIL");
        }
        return res;
    }
//    @RequestMapping("/taskview/{taskname}")
//    public String taskView(@PathVariable("taskname") String taskname, ModelMap modelMap) {
//        List<Task> taskList = TaskDAOImpl.getTask(taskname);
//        modelMap.addAttribute("taskList", taskList);
//        return "taskview";
//    }

    @RequestMapping(value = "workspacename/taskname/{taskname}", method = RequestMethod.POST)
    public String getTask(@PathVariable("taskname") String taskname, ModelMap modelMap, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        session.setAttribute("taskname", taskname);
        String workspacename = (String) session.getAttribute("workspacename");
        int workspaceId = workspaceDAOImpl.getWorkspaceIdByName(workspacename);
        List<String> allUser = userDAOImpl.getUserByWorkspace(workspaceId);
        modelMap.put("userList", allUser);
        modelMap.put("taskname", taskname);

        return "taskview";
    }
}
