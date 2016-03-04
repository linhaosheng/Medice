package com.drugsystem.bean.daobean;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/3.
 */
@Entity
public class User implements Serializable{

    private int user_id;                   //Ա��ID
    private String userNameame;              //Ա������
    private String role;                    //�û�Ȩ��
    private int totalCount;                //�û�����

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
