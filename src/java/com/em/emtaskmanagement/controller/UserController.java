/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.controller;

import com.em.emtaskmanagement.dao.UserDAOImpl;
import com.em.emtaskmanagement.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Vishal
 */
@Controller
public class UserController {
    
    HttpSession session;
    @Autowired
    private UserDAOImpl userDAOImpl;
    
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping(value = "/saveuser")
    public String saveUser() {
        return "saveuser";
    }
    
    @RequestMapping(value = "/authenticate")
    public String authenticate(HttpServletRequest request) {
        String name = request.getParameter("email");
        String pass = request.getParameter("password");
        session = request.getSession(true);
        int login = userDAOImpl.login(name, pass);
        if (login > 0) {
            session.setAttribute("UserName", name);
            return "home";
        }
        return "login";
    }
    
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(User user) {
        
        userDAOImpl.saveUser(user);
        return "welcome";
    }
}
