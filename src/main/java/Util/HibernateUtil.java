package Util;

import Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    static Configuration con = new Configuration().configure();
    static SessionFactory sf = con.buildSessionFactory();
    public static SessionFactory getSessionFactory(){
        return sf;
    }
}
