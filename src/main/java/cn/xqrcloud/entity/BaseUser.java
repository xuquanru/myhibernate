package cn.xqrcloud.entity;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: myhibernate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-01 21:13
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class BaseUser {
    private Integer user_id;
    private String user_name;
    private String user_password;

    //一个用户多个角色
    private Set<BaseRole> roles = new HashSet<>();

    public Set<BaseRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<BaseRole> roles) {
        this.roles = roles;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
