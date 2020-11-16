package Dao;

import Entity.Item;
import Util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public void createItem(Item item){
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.save(item);
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Item> getItems(){

        Session session = factory.openSession();
        Transaction tx = null;

        List<Item> items = new ArrayList<Item>();

        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from Item");
            items = q.list();
            tx.commit();
        } catch (HibernateError e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return items;
    }


    public void deleteItem(int iid){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "DELETE FROM Item WHERE iid = :iid" ;
            Query query = session.createQuery(hql);
            query.setParameter("iid", iid);
            query.executeUpdate();
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
