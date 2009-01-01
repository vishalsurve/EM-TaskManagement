/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.Task;
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
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveTask(Task task) {
        String taskname = task.getTaskname();
        sessionFactory.getCurrentSession().beginTransaction();
        if (taskname != "") {
            sessionFactory.getCurrentSession().save(task);
        } else {
        }
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    @Transactional
    public List<String> taskList() {

        List<String> taskList = new ArrayList();
        String hql = "from Task";
        sessionFactory.getCurrentSession().beginTransaction();
        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);
        //        List workspaceList = createQuery.list();
        Iterator iterate = createQuery.iterate();
        while (iterate.hasNext()) {
            Task task = (Task) iterate.next();
            String taskname = task.getTaskname();
            taskList.add(taskname);
        }
        return taskList;
    }
}
