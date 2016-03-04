package com.drugsystem.action;

import com.drugsystem.bean.daobean.StorageA;
import com.drugsystem.bean.daobean.StorageB;
import com.drugsystem.bean.daobean.StorageC;
import com.drugsystem.bean.daobean.StorageGoods;
import com.drugsystem.dao.DBTemplate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2015/11/21.
 * ����ģ��
 */
public class OutStorageAction extends ActionSupport
{
    private String goodsId;
    private long goodsCount;
    private String storage;
    private long totalCount;
    private int status;
    private String message;
    private long lowStorage;
    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public long getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }

    public String getStorage()
    {
        return storage;
    }

    public void setStorage(String storage)
    {
        this.storage = storage;
    }

    public long getGoodsCount()
    {
        return goodsCount;
    }

    public void setGoodsCount(long goodsCount)
    {
        this.goodsCount = goodsCount;
    }

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

    public long getLowStorage()
    {
        return lowStorage;
    }

    public void setLowStorage(long lowStorage)
    {
        this.lowStorage = lowStorage;
    }

    @Override
    public String execute() throws Exception
    {
        long lowerNum=0;           //仓库最小库存�
        long currentNum=0;
        long goodsCount=0;
        if((int) ActionContext.getContext().getSession().get("role")==4)
        {
            if (getStorage().equals("A"))
            {
                String sql_lowerNum = "select lowerStorage from storagea where goodsId=?";
                String sql_currentNum="select currentNum from storagea where goodsId=?";
                String sql_goodsCount="select goodsCount from storagea where goodsId=?";
                String update_sql= "update storagea set currentNum=?,goodsCount=? where goodsId=?";
                DBTemplate<StorageA> db_A1 = new DBTemplate<>();
                lowerNum = db_A1.loadEntityBySql(sql_lowerNum,getGoodsId());
                DBTemplate<StorageA> db_A2 = new DBTemplate<>();
                currentNum=db_A2.loadEntityBySql(sql_currentNum,getGoodsId());
                DBTemplate<StorageA> db_A3 = new DBTemplate<>();
                goodsCount=db_A3.loadEntityBySql(sql_goodsCount,getGoodsId());
                DBTemplate<StorageA> db_A4 = new DBTemplate<>();
                if (currentNum<goodsCount+getGoodsCount())
                {
                    status = -2100;
                    message = "库存不足";
                    ActionContext.getContext().getSession().put("status",status);

                }
                else
                {
                    if (db_A4.updateEntityById(update_sql,currentNum,goodsCount,getGoodsId())>0)
                    {
                        status = 110;
                        message = "Success";
                        ActionContext.getContext().getSession().put("status",status);

                    }
                    else
                    {
                        status = -110;
                        message = "保存出错";
                        ActionContext.getContext().getSession().put("status",status);
                    }
                }
            }
            else if (getStorage().equals("B"))
            {
                String sql_lowerNum = "select lowerStorage from storagea where goodsId=?";
                String sql_currentNum="select currentNum from storagea where goodsId=?";
                String sql_goodsCount="select goodsCount from storagea where goodsId=?";
                String update_sql= "update storagea set currentNum=?,goodsCount=? where goodsId=?";
                DBTemplate<StorageB> db_B1 = new DBTemplate<>();
                lowerNum = db_B1.loadEntityBySql(sql_lowerNum,getGoodsId());
                DBTemplate<StorageB> db_B2 = new DBTemplate<>();
                currentNum=db_B2.loadEntityBySql(sql_currentNum,getGoodsId());
                DBTemplate<StorageB> db_B3 = new DBTemplate<>();
                goodsCount=db_B3.loadEntityBySql(sql_goodsCount,getGoodsId());
                DBTemplate<StorageB> db_B4 = new DBTemplate<>();


                if (currentNum<goodsCount+getGoodsCount())
                {
                    status = -2100;
                    message = "库存不足";
                    ActionContext.getContext().getSession().put("status",status);
                }
                else
                {
                    if (db_B4.updateEntityById(update_sql, currentNum, goodsCount, getGoodsId())>0)
                    {
                        status = 110;
                        message = "Success";
                        ActionContext.getContext().getSession().put("status",status);

                    }
                    else
                    {
                        status = -1100;
                        message ="保存出错";
                        ActionContext.getContext().getSession().put("status",status);
                    }
                }
            }
            else if (getStorage().equals("C"))
            {
                String sql_lowerNum = "select lowerStorage from storagea where goodsId=?";
                String sql_currentNum="select currentNum from storagea where goodsId=?";
                String sql_goodsCount="select goodsCount from storagea where goodsId=?";
                String update_sql= "update storagec set currentNum=?,goodsCount=? where goodsId=?";

                DBTemplate<StorageC> db_C1 = new DBTemplate<>();
                lowerNum = db_C1.loadEntityBySql(sql_lowerNum);
                DBTemplate<StorageC> db_C2 = new DBTemplate<>();
                DBTemplate<StorageC> db_C3 = new DBTemplate<>();
                DBTemplate<StorageC> db_C4 = new DBTemplate<>();
    ;
                if (currentNum<goodsCount+getGoodsCount())
                {
                    status = -2100;
                    message = "库存不足";
                    ActionContext.getContext().getSession().put("status",status);
                }
                else
                {
                    if (db_C4.updateEntityById(update_sql, currentNum, goodsCount, getGoodsId())>0)
                    {
                        status = 110;
                        message = "Success";
                        ActionContext.getContext().getSession().put("status",status);

                    }
                    else
                    {
                        status = -1100;
                        message = "保存出错";
                        ActionContext.getContext().getSession().put("status",status);
                    }
                }
            }
        }else {
            status=-110;
            message="权限不足";
            ActionContext.getContext().getSession().put("status",status);
        }
        return SUCCESS;
    }
}
