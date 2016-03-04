package com.drugsystem.action;

import com.drugsystem.bean.daobean.GoodsInfo;

import com.drugsystem.dao.DBTemplate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



/**获取药品详细信息
 * Created by Administrator on 2015/11/21.
 */
public class GetGoodsInfoAction extends ActionSupport
{
    private int status;
    private String message;
    private String goodsId;
    private GoodsInfo goodsInfo;
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

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
        if((int) ActionContext.getContext().getSession().get("role")==1)
        {
            DBTemplate<GoodsInfo> db_getGoods = new DBTemplate<>();
            goodsInfo = db_getGoods.loadEntity(GoodsInfo.class,getGoodsId());
            if (getGoodsInfo() != null)
            {
                status = 100;
                message = "Success";
                ActionContext.getContext().getSession().put("status",1000);
                ActionContext.getContext().getSession().put("goodsInfo",getGoodsInfo());

            }
            else
            {
                status = -200;
                message = "未知药品";
                ActionContext.getContext().getSession().put("status",100);
            }
        }else {
            status=-100;
            message="权限不足 ";
            ActionContext.getContext().getSession().put("status",100);
        }
        return SUCCESS;
    }
}
