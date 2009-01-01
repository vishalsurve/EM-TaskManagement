package com.em.emtaskmanagement.dao;

import com.em.emtaskmanagement.model.Comment;
import com.em.emtaskmanagement.model.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CommentDAO {

    @Autowired
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        CommentDAO.sessionFactory = sessionFactory;
    }

    public static void addComment(int taskid, int userid, String comment) {

        sessionFactory.getCurrentSession().beginTransaction();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
        Date date = new Date();
        String commentdate = dateFormat.format(date);

        Comment comment1 = new Comment();

        comment1.setComment(comment);
        comment1.setCommentdate(commentdate);
        comment1.setTaskid(taskid);
        comment1.setUserid(userid);

        sessionFactory.getCurrentSession().save(comment1);
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    public static void deleteComments(int commentid) {
        sessionFactory.getCurrentSession().beginTransaction();

        String hql = "delete from Comment where commentid = " + commentid;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    public static List<Comment> getComments(int taskid) {
        sessionFactory.getCurrentSession().beginTransaction();

        String hql = "from Comment where taskid = " + taskid;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<Comment> commentsList = query.list();
        return commentsList;
    }
}