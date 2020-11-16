package Dao;

import Entity.*;
import Util.HibernateUtil;
import org.hibernate.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public void addCart(int iid, int uid, String time){
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            SQLQuery q = session.createSQLQuery("insert into cart values (:iid,:uid,:time)");
            q.setParameter("iid", iid);
            q.setParameter("uid", uid);
            q.setParameter("time", time);
            q.executeUpdate();
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Object> getTrans(){

        Session session = factory.openSession();
        Transaction tx = null;

        List<Object> trans = new ArrayList<Object>();

        try {
            tx = session.beginTransaction();
            SQLQuery q = session.createSQLQuery("select c.iid,c.time,c.uid,i.iname from cart c, item i, user u where c.iid=i.iid and c.uid=u.uid");
            q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            trans = q.list();
            tx.commit();
        } catch (HibernateError e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return trans;
    }


    public void deleteTran(int iid,int uid){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            SQLQuery q = session.createSQLQuery("delete from cart where iid=:iid and uid=:uid");
            q.setParameter("iid", iid);
            q.setParameter("uid", uid);
            q.executeUpdate();
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
