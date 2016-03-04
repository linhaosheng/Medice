package com.drugsystem.model;
import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/11/21.
 * ҩƷ����Ա
 */
@Entity
public class DrugAdministrator
{
    private String uid;
    private String name;
    private String password;
    private Integer status;
    private Timestamp lastLogin;
    private String roleName;
    private String gender;
   @Id
    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public Timestamp getLastLogin()
    {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }
}
