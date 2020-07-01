package cn.xqrcloud.demo.day01;

import cn.xqrcloud.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-06-25 15:35
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class HibernateDemo {
    @Test
    public void testAdd(){

        /*《总体流程》
           |1————————加载核心配置cfg
           |2————————创建sessionFactory 对象
           |3————————创建session对象
           |4————————开启Transaction
           |5————————写CRUD逻辑
           |6————————提交事务
           |7————————关闭资源
           🐷流程说明:END1表示流程1
        */
        //它会在src目录下找到hibernate.cfg.xml
        //然后把它加载封装成对象
        Configuration cfg=new Configuration();
        cfg.configure();/*END1✔*/

        //cfg 创建sessionFactory对象
        //在过程中，根据映射关系，配置数据库XML文件就会把表创建
        SessionFactory sessionFactory = cfg.buildSessionFactory();/*END2✔*/

        //创建session对象，session类似连接，是对连接的封装涉及数据库账号密码
        Session currentSession =sessionFactory.openSession();/*END3✔*/

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
        sessionFactory.close();/*END7✔*/

    }
}
