package cn.xqrcloud.demo.day06;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.Customer;
import cn.xqrcloud.entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description 对象导航
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 23:58
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo1 {
    @Test
    public void testSelect1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;


        try {

             session = HibernateUtils.getSession();
            tx=session.beginTransaction();
            Customer customer = session.get(Customer.class, 8);
            Set<LinkMan> linksMans = customer.getLinksMans();
            System.err.println(linksMans.size());
        }catch (Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }
}
