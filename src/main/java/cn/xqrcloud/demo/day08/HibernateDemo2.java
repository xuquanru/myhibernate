package cn.xqrcloud.demo.day08;

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
 * 🍁 Description HQL左外连接
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 23:58
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo2 {
    @Test
    public void testSelect1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;


        try {

            session = HibernateUtils.getSession();
            tx=session.beginTransaction();
            Query query = session.createQuery("from Customer c left  join c.linksMans");
            Query query1 = session.createQuery("from Customer c left  join fetch c.linksMans");
            List list = query.list();
            List list1 = query1.list();
            System.err.println();

        }catch (Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }
}
