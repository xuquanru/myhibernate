package cn.xqrcloud.demo.day01;

import cn.xqrcloud.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-06-25 20:18
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo2 {
    @Test
    public void testAdd(){

        Session currentSession = HibernateUtils.getSession();
        //开启事务
        Transaction transaction = currentSession.beginTransaction();/*END4✔*/
        //写具体CRUD逻辑
        User user = new User();
        user.setAge(100);
        user.setName("尼玛");
        currentSession.save(user);/*END5✔*/
        //提交事务
        transaction.commit();/*END6✔*/
        //关闭资源
        currentSession.close();

    }
}
