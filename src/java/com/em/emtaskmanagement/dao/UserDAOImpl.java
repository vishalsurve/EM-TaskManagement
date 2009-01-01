/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vishal
 */
@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private static SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Transactional
    public int login(String name, String pass) {

        int count = 0;
        String email = null;
        String password = null;
        String hql = "from User user where user.email='" + name + "'" + "and user.password='" + pass + "'";
        sessionFactory.getCurrentSession().beginTransaction();
        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);

        List<User> records = createQuery.list();
        Iterator<User> iterator = records.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            email = user.getEmail();
            password = user.getPassword();
        }
        if (records.size() > 0 && name.equals(email) && pass.equals(password)) {
            count++;
        } else {
        }
        sessionFactory.getCurrentSession().beginTransaction().commit();
        return count;
    }

    @Transactional
    public int findUserIdbyEmail(String email) {

        int userid = 0;
        String hql = "from User where email='" + email + "'";
        sessionFactory.getCurrentSession().beginTransaction();
        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);
        Iterator iterate = createQuery.iterate();
        while (iterate.hasNext()) {
            User user = (User) iterate.next();
            userid = user.getUserid();
        }
        sessionFactory.getCurrentSession().beginTransaction().commit();
        return userid;
    }

    @Transactional
    public List getUserIdByName(String[] userlist) {

        int userid;

        List list = new ArrayList();
        for (String name : userlist) {
            String username = name;

            String hql = "from User where firstname='" + username + "'";
            sessionFactory.getCurrentSession().beginTransaction();
            Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);
            Iterator iterate = createQuery.iterate();

            while (iterate.hasNext()) {
                User user = (User) iterate.next();
                userid = user.getUserid();
                list.add(user);
            }
            sessionFactory.getCurrentSession().beginTransaction().commit();
        }

        return list;
    }

    @Transactional
    public void saveUser(User user) {
        String firstname = user.getFirstname();
        String email = user.getEmail();
        sessionFactory.getCurrentSession().beginTransaction();
        if (firstname != "" && email != "") {
            sessionFactory.getCurrentSession().saveOrUpdate(user);
        } else {
        }
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    public  List<String> getAllUser() {
        List<String> list = new ArrayList<String>();
        String hql = "from User";
        sessionFactory.getCurrentSession().beginTransaction();
        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);
        Iterator iterate = createQuery.iterate();
        while (iterate.hasNext()) {
            User user = (User) iterate.next();
            String firstname = user.getFirstname();
            list.add(firstname);
        }
        sessionFactory.getCurrentSession().beginTransaction().commit();
        return list;
    }
    
    
     public static List listUser() {
        sessionFactory.getCurrentSession().beginTransaction();
        String hql = "from User";
        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);

        List<User> users = createQuery.list();
        return users;
    }

    public static List listUserAccordingID(int userid) {
        sessionFactory.getCurrentSession().beginTransaction();
        String hql = "from User where userid=" + userid;
        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);

        List<User> users = createQuery.list();
        return users;
    }
}
