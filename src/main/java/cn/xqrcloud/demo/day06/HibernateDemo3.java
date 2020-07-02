package cn.xqrcloud.demo.day06;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.BaseRole;
import cn.xqrcloud.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import javax.management.relation.Role;
import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description HQL
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 23:58
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo3 {
    @Test
    public void testSelect1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;


        try {
            session = HibernateUtils.getSession();
            tx=session.beginTransaction();
            Query roles = session.createQuery("from BaseRole ");
            //设置分页数据的开始位置
            roles.setFirstResult(0);
            //每页记录数据
            roles.setMaxResults(2);
            List<BaseRole> list = roles.list();
            for (BaseRole role : list) {
                System.err.println(role);
            }
            tx.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            tx.rollback();
        }finally{
            session.close();
        }
    }
}
