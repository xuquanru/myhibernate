package cn.xqrcloud.demo.day10;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.Customer;
import cn.xqrcloud.entity.LinkMan;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description 批量抓取
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 23:58
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo1 {
    @Test
    public void testSelect1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;


        try {

            session = HibernateUtils.getSession();
            tx=session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            List<Customer> list = criteria.list();
            for (Customer customer : list) {
                Set<LinkMan> linksMans = customer.getLinksMans();
                for (LinkMan linksMan : linksMans) {
                    System.out.println(linksMan);
                    //这段代码可以再HBM配置优化 batch-size,越大性能越高，减少发送次数
                }
            }

        }catch (Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }
}
