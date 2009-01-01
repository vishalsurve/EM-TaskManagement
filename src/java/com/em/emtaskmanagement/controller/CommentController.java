package com.em.emtaskmanagement.controller;

import com.em.emtaskmanagement.dao.CommentDAO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bhavin
 */
@Controller
public class CommentController {

    @RequestMapping(value = "/addcomment")
    public void addComment(HttpServletRequest request) {

        int taskid = Integer.parseInt(request.getParameter(null));
        int userid = Integer.parseInt(request.getParameter(null));
        String comment = request.getParameter(null);
        CommentDAO.addComment(taskid, userid, comment);

    }

    @RequestMapping("/deletecomment/{commentid}")
    public String editUser(@PathVariable("commentid") Integer commentid, ModelMap modelMap) {
        CommentDAO.deleteComments(commentid);
        return "commentdeleted";
    }
}
