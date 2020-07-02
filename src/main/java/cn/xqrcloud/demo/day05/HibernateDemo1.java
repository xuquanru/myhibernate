package cn.xqrcloud.demo.day05;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.BaseRole;
import cn.xqrcloud.entity.BaseUser;
import cn.xqrcloud.entity.Customer;
import cn.xqrcloud.entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 22:06
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo1 {
    @Test
    public void testSqlsave() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            //就干一件事，把linkman 表的cid 修改下，却是操作了多步骤

            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();
            BaseUser baseUser = new BaseUser();
            baseUser.setUser_name("Lucy");
            baseUser.setUser_password("123456");

            BaseUser baseUser1 = new BaseUser();
            baseUser1.setUser_name("Mark");
            baseUser1.setUser_password("7890");

            BaseRole baseRole = new BaseRole();
            baseRole.setRole_memo("老师");
            baseRole.setRole_name("老师");

            BaseRole baseRole1 = new BaseRole();
            baseRole1.setRole_memo("教授");
            baseRole1.setRole_name("教授");

            BaseRole baseRole2 = new BaseRole();
            baseRole2.setRole_memo("学生");
            baseRole2.setRole_name("学生");

            baseUser.getRoles().add(baseRole);
            baseUser.getRoles().add(baseRole1);
            baseUser1.getRoles().add(baseRole1);
            baseUser1.getRoles().add(baseRole2);

            session.save(baseUser);
            session.save(baseUser1);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}
