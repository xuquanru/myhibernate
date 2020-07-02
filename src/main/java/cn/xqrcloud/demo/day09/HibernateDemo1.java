package cn.xqrcloud.demo.day09;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.Customer;
import cn.xqrcloud.entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description HQL左外连接
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
            Customer load = session.load(Customer.class, 8);
            //load 对象不会马上发送sql,但是会得到ID值
            //当要获取其他值时候那么他才会去获得值
            System.err.println(load.getCid());
            System.err.println(load.getCustName());

            //延迟加载其他属性
            Set<LinkMan> linksMans = load.getLinksMans();
            System.err.println(linksMans.size());

        }catch (Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }
}
