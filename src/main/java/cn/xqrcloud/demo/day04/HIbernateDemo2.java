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
 * 🍁 Create: 2020-07-01 00:29
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HIbernateDemo2 {
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
            customer.setCustName("肖客户");
            customer.setCustLevel("vip1");
            customer.setCustSource("网络1");
            customer.setCustMobile("1101");
            customer.setCustPhone("1301");

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("Lei");
            linkMan.setLkm_gender("男");
            linkMan.setLkm_phone("234");

            //建立双向关系
            customer.getLinksMans().add(linkMan);
            session.save(customer);


            tx.commit();
        }catch (Exception e){

        }
    }

}
