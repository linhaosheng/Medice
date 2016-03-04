package com.drugsystem.action;

import com.drugsystem.dao.DBTemplate;
import com.drugsystem.model.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by Administrator on 2015/11/21.
 * 获取用户列表
 */
public class GetUserListAction extends ActionSupport
{
    private int status;
    private String message;
    private String userId;
    private int pageNow=0;
    private int pageSize=15;
    private String roleName;


    private List<SystemAdministrator>systemList;


    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getPageNow()
    {
        return pageNow;
    }

    public void setPageNow(int pageNow)
    {
        this.pageNow = pageNow;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }




    @Override
    public String execute() throws Exception
    {
        String getRoleName=getRoleName().toString();
        Page page=new Page();
        page.setPageNow(getPageNow());
        page.setPageSize(getPageSize());
        if((int) ActionContext.getContext().getSession().get("role")==3)
        {
            DBTemplate<SystemAdministrator> db_drug = new DBTemplate<>();
            systemList = db_drug.loadListEntities(page);
            if (systemList != null)
            {
                status = 100;
                message = "查询成功";
            }else {
                status=-1000;
                message="内部错误";
            }
        }else {
            status=-100;
            message="权限不足";
        }
        return SUCCESS;
    }
}
