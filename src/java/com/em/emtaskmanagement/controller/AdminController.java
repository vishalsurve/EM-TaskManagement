package com.em.emtaskmanagement.controller;

import com.em.emtaskmanagement.dao.AdminDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bhavin
 */
@Controller
public class AdminController {

    HttpSession session;
    @Autowired
    private AdminDAO adminDAO;

    @RequestMapping(value = "/adminlogin")
    public String login() {
        return "adminlogin";
    }

    @RequestMapping(value = "/authenticateadmin")
    public String authenticateadmin(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        session = request.getSession(true);

        if (adminDAO.authenticAdmin(email, password)) {
            return "saveuser";
        }
//        return "login";
        return "saveuser";
    }
}
