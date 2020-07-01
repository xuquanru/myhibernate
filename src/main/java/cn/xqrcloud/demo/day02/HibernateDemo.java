package cn.xqrcloud.demo.day02;

import cn.xqrcloud.demo.day01.HibernateUtils;
import cn.xqrcloud.entity.Person;
import cn.xqrcloud.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-06-26 15:51
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo {
    @Test
    public void testAdd(){
        Session currentSession = HibernateUtils.getSession();
        //开启事务
        Transaction transaction = currentSession.beginTransaction();/*END4✔*/
        //写具体CRUD逻辑
        Person user = new Person();
        user.setAge(100);
        user.setName("尼玛");
        currentSession.save(user);/*END5✔*/
        //提交事务
        transaction.commit();/*END6✔*/
        //关闭资源
        currentSession.close();
    }


    @Test
    public void testGet(){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        //第一个是类，第二个是id值
        User user = session.get(User.class, 1);
        transaction.commit();
        session.close();

    }


    @Test
    public void testUpdate(){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        //第一个是类，第二个是id值
        User user = session.get(User.class, 1);
        user.setName("猫和老鼠");
        session.update(user);
        transaction.commit();
        session.close();

    }

    @Test
    public void testDelete(){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        //第一个是类，第二个是id值
        User user = session.get(User.class, 2);
        session.delete(user);
        transaction.commit();
        session.close();

    }

    @Test
    public void testTx(){

        Session session=null;
        Transaction transaction=null;
        try {
            //本地线程Session 需要配置cfg
             session = HibernateUtils.getCurrentSession();
             transaction = session.beginTransaction();
            //第一个是类，第二个是id值
            User user = session.get(User.class, 3);
            user.setName("我是标准");
            session.update(user);
            //int i = 10 / 0;
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();//教程上说这里session会报空指针，但是测试还是不会
        }

    }

}
