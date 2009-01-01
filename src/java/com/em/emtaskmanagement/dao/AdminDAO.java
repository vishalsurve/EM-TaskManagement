package com.em.emtaskmanagement.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bhavin
 */
@Repository
public class AdminDAO {

    @Autowired
    private static SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Boolean authenticAdmin(String email, String password) {

        sessionFactory.getCurrentSession().beginTransaction();

        String sql1 = "select password from User where email= '" + email + " ' ";
        String sql2 = "select isAdmin from User where email= '" + email + " ' ";

        Query createQuery1 = sessionFactory.getCurrentSession().createQuery(sql1);
        Query createQuery2 = sessionFactory.getCurrentSession().createQuery(sql2);

        List list = createQuery1.list();
        List list2 = createQuery2.list();

        if (list.contains(password) && list2.contains("true")) {
            return true;
        }
        return false;
    }
}
