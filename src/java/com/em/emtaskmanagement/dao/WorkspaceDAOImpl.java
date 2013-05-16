/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.Workspace;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public void saveWorkspace(Workspace workspace) {

        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(workspace);
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }
}
