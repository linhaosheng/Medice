package com.drugsystem.action;

import com.drugsystem.bean.daobean.GoodsInfo;
import com.drugsystem.bean.daobean.StorageA;
import com.drugsystem.bean.daobean.StorageB;
import com.drugsystem.bean.daobean.StorageC;
import com.drugsystem.dao.DBTemplate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by Administrator on 2015/11/21.
 * �ֿ��ѯģ��
 */
public class CheckStorageAction extends ActionSupport
{
    private int status;
    private String message;


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




    @Override
    public String execute() throws Exception
    {
        List<GoodsInfo>goodsInfos=null;
         if((int) ActionContext.getContext().getSession().get("role")==3)
         {
                 DBTemplate<GoodsInfo>dbTemplate=new DBTemplate<>();
                 goodsInfos=dbTemplate.loadAllEntity();
                 DBTemplate<GoodsInfo>dbTemplate1=new DBTemplate<>();
                 int num=dbTemplate1.loadNum();
                 ActionContext.getContext().getSession().put("goodsInfos",goodsInfos);
                 ActionContext.getContext().getSession().put("status",2000);
                 ActionContext.getContext().getSession().put("num",num);
         }else {
             status=-1000;
             message="没有数据";
         }
        return SUCCESS;
    }
}
