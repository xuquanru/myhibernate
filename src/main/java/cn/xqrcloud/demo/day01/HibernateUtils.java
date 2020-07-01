package cn.xqrcloud.demo.day01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-06-25 20:00
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateUtils {
    private static Configuration cfg = null;
    private static SessionFactory sessionFactory = null;
    private static Session session = null;
    static {
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
        session =sessionFactory.openSession();
    }

    public static final SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static final Session getSession(){
        return session;
    }
//   获取本地线程相关的session
    public static final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

}
