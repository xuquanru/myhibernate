package cn.xqrcloud.demo.day04;

import cn.xqrcloud.demo.day01.HibernateUtils;
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
 * 🍁 Create: 2020-07-01 10:08
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo4 {
    @Test
    public void testSqlUpdate() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            //就干一件事，把linkman 表的cid 修改下，却是操作了多步骤

            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();
            Customer customer = session.get(Customer.class, 8);
            LinkMan linkMan = session.get(LinkMan.class, 8);

            //设置持久态对象，他会双向维护外键，修改Customer一次，修改LinkMan一次，造成效率问题需要配置一的维护
            customer.getLinksMans().add(linkMan);
            linkMan.setCustomer(customer);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}
