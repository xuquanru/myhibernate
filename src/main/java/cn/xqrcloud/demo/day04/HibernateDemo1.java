package cn.xqrcloud.demo.day04;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.Customer;
import cn.xqrcloud.entity.LinkMan;
import cn.xqrcloud.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.Test;

import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 00:02
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo1 {
    @Test
    public void testSqlSave() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustName("大客户");
            customer.setCustLevel("vip");
            customer.setCustSource("网络");
            customer.setCustMobile("110");
            customer.setCustPhone("130");

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("lucy");
            linkMan.setLkm_gender("女");
            linkMan.setLkm_phone("1314");

            LinkMan linkMan1 = new LinkMan();
            linkMan1.setLkm_name("lucy1");
            linkMan1.setLkm_gender("女");
            linkMan1.setLkm_phone("13145");
            //建立双向关系
            customer.getLinksMans().add(linkMan);
            customer.getLinksMans().add(linkMan1);

            linkMan.setCustomer(customer);
            session.save(customer);
            session.save(linkMan);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
