package com.drugsystem.action;

import com.drugsystem.dao.DBTemplate;
import com.drugsystem.model.DrugAdministrator;
import com.drugsystem.model.Libaray;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/12/9.
 */
public class AddAdministrator extends ActionSupport
{
    private String uid;
    private String password;
    private String adminstratorKind;
    private String name;
    private String gender;

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAdminstratorKind()
    {
        return adminstratorKind;
    }

    public void setAdminstratorKind(String adminstratorKind)
    {
        this.adminstratorKind = adminstratorKind;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Override
    public String execute() throws Exception
    {
        if("仓库管理员".equals(getAdminstratorKind())){
            DBTemplate<Libaray>dbTemplate=new DBTemplate<>();
            Libaray libaray=new Libaray();
            libaray.setUid(getUid());
            libaray.setPassword(getPassword());
            libaray.setName(getName());
            libaray.setGender("男");
            libaray.setLastLogin(new Timestamp(System.currentTimeMillis()));
            libaray.setStatus(2);
            libaray.setRoleName(getAdminstratorKind());
            int num=dbTemplate.saveEntity(libaray);
            if(num>0){
                ActionContext.getContext().getSession().put("status",10000);
            }else{
                ActionContext.getContext().getSession().put("status",-10000);
            }
        }
        else if ("药品管理员".equals(getAdminstratorKind())){
            DBTemplate<DrugAdministrator>dbTemplate=new DBTemplate<>();
            DrugAdministrator drugAdministrator=new DrugAdministrator();
            drugAdministrator.setUid(getUid());
            drugAdministrator.setPassword(getPassword());
            drugAdministrator.setName(getName());
            drugAdministrator.setGender("女");
            drugAdministrator.setLastLogin(new Timestamp(System.currentTimeMillis()));
            drugAdministrator.setStatus(1);
            drugAdministrator.setRoleName(getAdminstratorKind());
            int num=dbTemplate.saveEntity(drugAdministrator);
            if(num>0){
                ActionContext.getContext().getSession().put("status",10000);
            }else{
                ActionContext.getContext().getSession().put("status",-10000);
            }
        }
        return SUCCESS;
    }
}
