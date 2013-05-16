/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.User;
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
public class UserDAOImpl {

    @Autowired
    private SessionFactory sessionFactory;

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
    public void saveUser(User user) {

        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }
}
