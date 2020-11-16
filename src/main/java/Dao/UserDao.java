package Dao;


import Entity.User;
import Util.HibernateUtil;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    public User getUser(){

        Session session = factory.openSession();
        Transaction tx = null;

        List<User> users = new ArrayList<User>();

        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from User");
            users = q.list();
            tx.commit();
        } catch (HibernateError e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return users.get(0);
    }

    public void addUser(User user){
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
