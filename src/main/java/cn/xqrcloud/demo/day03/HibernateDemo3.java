package cn.xqrcloud.demo.day03;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-06-29 23:06
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo3 {

    @Test
    public void testSqlQuery(){

        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction tx=null;

        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();

            NativeQuery sqlQuery = session.createSQLQuery(" select * from user");
            sqlQuery.addEntity(User.class);//这个很重要，把Object 转对象


//            List<Object[]>  list = sqlQuery.list();
//            for (Object[] objects : list) {
//                System.out.println(Arrays.toString(objects));
//            }
            List <User>  list = sqlQuery.list();
            for (User user : list) {
                System.out.println(user);
            }

            tx.commit();

        } catch (Exception e) {

        }finally {

        }


    }
}
