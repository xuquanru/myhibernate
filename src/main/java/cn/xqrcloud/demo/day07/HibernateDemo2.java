package cn.xqrcloud.demo.day07;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description 对象导航
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 23:58
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo2 {
    @Test
    public void testSelect1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;


        try {

            session = HibernateUtils.getSession();
            tx=session.beginTransaction();
            //创建返回对象
            Criteria criteria = session.createCriteria(Customer.class);
            //设置条件
            criteria.add(Restrictions.eq("cid", 1));
            criteria.add(Restrictions.eq("custName", "百度"));
            criteria.add(Restrictions.like("custName", "%百"));
            //设置排序
            criteria.addOrder(Order.asc("cid"));

            //设置分页
            criteria.setFirstResult(0);
            criteria.setMaxResults(3);
            List<Customer> list = criteria.list();

        }catch (Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }
}
