package cn.xqrcloud.demo.day05;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.BaseRole;
import cn.xqrcloud.entity.BaseUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 23:44
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo3 {
    @Test
    public void testSqlDelete() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            //就干一件事，把linkman 表的cid 修改下，却是操作了多步骤
            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();

            BaseUser baseUser = session.get(BaseUser.class, 4);
                session.delete(baseUser);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}
