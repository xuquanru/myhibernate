package cn.xqrcloud.demo.day06;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.BaseRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description 投影函数
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 23:58
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo4 {
    @Test
    public void testSelect1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;


        try {
            session = HibernateUtils.getSession();
            tx=session.beginTransaction();

            Query roles = session.createQuery("select  custName,custLevel,custSource from Customer ");

            //这时候不能用 具体对象了
            List<Object> list = roles.list();
            for (Object role : list) {
                System.err.println(role);
            }
            tx.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            tx.rollback();
        }finally{
            session.close();
        }
    }
}
