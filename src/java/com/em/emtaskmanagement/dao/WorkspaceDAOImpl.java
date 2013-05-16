/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.Workspace;
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
public class WorkspaceDAOImpl implements WorkspaceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveWorkspace(Workspace workspace) {

        String workspacename = workspace.getWorkspacename();
        sessionFactory.getCurrentSession().beginTransaction();
        if (workspacename != "") {
            sessionFactory.getCurrentSession().save(workspace);
        } else {
        }
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    @Transactional
    public List<String> workspaceList() {

        List<String> workspaceList = new ArrayList();
        String hql = "from Workspace";
        sessionFactory.getCurrentSession().beginTransaction();
        Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);
        //        List workspaceList = createQuery.list();
        Iterator iterate = createQuery.iterate();
        while (iterate.hasNext()) {
            Workspace workspace = (Workspace) iterate.next();
            String workspacename = workspace.getWorkspacename();
            workspaceList.add(workspacename);
        }
        return workspaceList;
    }
}
