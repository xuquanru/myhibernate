package cn.xqrcloud.demo.day03;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-06-29 22:55
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HIbernateDemo1 {
    @Test
    public void testCriteria(){

        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction tx=null;

        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(User.class);
            List<User> list = criteria.list();
            for (User user : list) {
                System.err.println(user);
            }

            tx.commit();

        } catch (Exception e) {

        }finally {

        }


    }
}
