package com.drugsystem.action;

import com.drugsystem.bean.daobean.GoodsInfo;
import com.drugsystem.dao.DBTemplate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2015/11/21.
 * 药品库存查询模块
 */

public class CheckGoodsAction extends ActionSupport
{
    private int status;
    private String message;
    private String goodsId;
    private GoodsInfo goodsInfo;

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

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public GoodsInfo getGoodsInfo()
    {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo)
    {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public String execute() throws Exception
    {
        if((int)ActionContext.getContext().getSession().get("role")==1)
        {
            DBTemplate<GoodsInfo> db_goodsInfo = new DBTemplate<>();
            goodsInfo = db_goodsInfo.loadEntity(GoodsInfo.class,getGoodsId());
            if (goodsInfo != null)
            {
                status = 100;
                message = "查询成功";
                ActionContext.getContext().getSession().put("goodsInfo",getGoodsInfo());
            }
            else
            {
                status = -200;
                message = "没有药品";
            }
        }else {
            status=-100;
            message="权限不足";
        }
        return SUCCESS;
    }
}
