package cn.xqrcloud.demo.day06;

import cn.xqrcloud.demo.day01.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description HQL
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 23:58
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo5 {
    @Test
    public void testSelect1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;


        try {
            session = HibernateUtils.getSession();
            tx=session.beginTransaction();
            Query query = session.createQuery("select count(*) from Customer ");
            Object o = query.uniqueResult();
            System.err.println(o);
            tx.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            tx.rollback();
        }finally{
            session.close();
        }
    }
}
