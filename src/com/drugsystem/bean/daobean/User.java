package com.drugsystem.bean.daobean;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/3.
 */
@Entity
public class User implements Serializable{

    private int user_id;                   //员工ID
    private String userNameame;              //员工姓名
    private String role;                    //用户权限
    private int totalCount;                //用户数量

    @GeneratedValue
    @Id
    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }
    public int getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getUserNameame()
    {
        return userNameame;
    }

    public void setUserNameame(String userNameame)
    {
        this.userNameame = userNameame;
    }

}
