package com.drugsystem.action;

import com.drugsystem.bean.daobean.GoodsInfo;
import com.drugsystem.dao.DBTemplate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/11/21.
 * 药品详细信息录入模块
 */
public class AddGoodsAction extends ActionSupport
{
    private int status;
    private String message;
    private String goodsId;
    private String goodsName;
    private String unit;
    private String spec;
    private String source;
    private String contact;
    private String tel;
    private long alertValue;


    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public long getAlertValue()
    {
        return alertValue;
    }

    public void setAlertValue(long alertValue)
    {
        this.alertValue = alertValue;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSpec()
    {
        return spec;
    }

    public void setSpec(String spec)
    {
        this.spec = spec;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    @Override
    public String execute() throws Exception
    {
        System.out.println("role------------"+(int) ActionContext.getContext().getSession().get("role"));
        if((int) ActionContext.getContext().getSession().get("role")==1)
        {
            GoodsInfo goodsInfo = new GoodsInfo();
            goodsInfo.setGoodsId(getGoodsId());
            goodsInfo.setGoodsName(getGoodsName());
            goodsInfo.setUnit(getUnit());
            goodsInfo.setSpec(getSpec());
            goodsInfo.setSource(getSource());
            goodsInfo.setDate(new Timestamp(System.currentTimeMillis()));
            goodsInfo.setContact(getContact());
            goodsInfo.setTel(getTel());
            goodsInfo.setAlertValue(getAlertValue());

            DBTemplate<GoodsInfo> db_addGoods = new DBTemplate<>();
            int result = db_addGoods.saveEntity(goodsInfo);
            if (result > 0)
            {
                status = 100;
                message = "添加成功";
                ActionContext.getContext().getSession().put("status",100);
                ActionContext.getContext().getSession().put("message",message);
            }
            else
            {
                status = -200;
                message = "添加失败";
                ActionContext.getContext().getSession().put("status",-200);
            }
        }else {
            status=-100;
            message="权限不足";
            ActionContext.getContext().getSession().put("status",-100);
        }
        return SUCCESS;
    }
}
