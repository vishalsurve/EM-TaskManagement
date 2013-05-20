/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.Task;
import com.em.emtaskmanagement.model.User;
import com.em.emtaskmanagement.model.Workspace;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
    @Override
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

    @Transactional
    @Override
    public List<String> taskAssignedByMe(int ownerid) {

        List<String> list = new ArrayList<String>();
        String hql = "from Task where ownerid=" + ownerid;
        sessionFactory.getCurrentSession().beginTransaction();
        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);
        Iterator iterate = createQuery.iterate();
        while (iterate.hasNext()) {
            Task task = (Task) iterate.next();
            String taskname = task.getTaskname();
            list.add(taskname);
        }
        sessionFactory.getCurrentSession().getTransaction().commit();
        return list;
    }

    @Transactional
    @Override
    public List<String> taskAssignedToMe(int userid) {

        List<String> list = new ArrayList<String>();
        String sql = "select taskname from task t inner join task_user tu on tu.task_id = t.taskid inner join user u on u.userid = tu.user_id where u.userid=" + userid;
        sessionFactory.getCurrentSession().beginTransaction();
        SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
        List list1 = createSQLQuery.list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return list1;

    }

//    @Transactional
//    public static List<Task> getTask(String taskName) {
//        String hql = "from Task where taskname = " + taskName;
//        sessionFactory.getCurrentSession().beginTransaction();
//        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);
//        List<Task> tasklist = createQuery.list();
//        sessionFactory.getCurrentSession().beginTransaction().commit();
//        return tasklist;
//    }
    public int getTaskIdByName(String taskname) {
        int taskid = 0;
        String hql = "from Task where taskname='" + taskname + "'";
        sessionFactory.getCurrentSession().beginTransaction();
        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);
        Iterator iterate = createQuery.iterate();
        while (iterate.hasNext()) {
            Task task = (Task) iterate.next();
            taskid = task.getTaskid();
        }
        sessionFactory.getCurrentSession().getTransaction().commit();
        return taskid;
    }

    public void addUserList(int taskId, List UserId) {

        User user = null;
        int userid = 0;

        sessionFactory.getCurrentSession().beginTransaction();
        Task task = (Task) sessionFactory.getCurrentSession().load(Task.class, taskId);
        Set<User> users = new HashSet<User>();

        Iterator iterator = UserId.iterator();
        while (iterator.hasNext()) {
            User object = (User) iterator.next();
            userid = object.getUserid();
            user = (User) sessionFactory.getCurrentSession().load(User.class, userid);
            users.add(user);
        }
        task.setUser(users);
        sessionFactory.getCurrentSession().save(task);
        
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }
}
