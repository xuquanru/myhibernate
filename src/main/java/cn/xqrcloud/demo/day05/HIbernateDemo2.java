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
 * 🍁 Create: 2020-07-01 22:53
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HIbernateDemo2 {
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

            BaseUser baseUser = session.get(BaseUser.class, 3);
            BaseRole baseRole = session.get(BaseRole.class, 3);
           // baseUser.getRoles().add(baseRole);
            //去掉某个角色
            baseUser.getRoles().remove(baseRole);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}
