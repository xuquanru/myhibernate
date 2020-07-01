package cn.xqrcloud.demo.day06;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.Customer;
import cn.xqrcloud.entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description HQL
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
            Query from_customer = session.createQuery("from Customer where  cid=?1 and custName like ?2 ");
            from_customer.setParameter(1, 8);
            from_customer.setParameter(2, "%大客户%");
            //设置？号值，第一个？号是位置值，现在从1开始
            List<Customer> list = from_customer.list();
            list.forEach(customer -> System.err.println(customer));
            tx.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            tx.rollback();
        }finally{
            session.close();
        }
    }
}
