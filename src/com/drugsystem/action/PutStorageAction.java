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
 * 入库模块
 */
public class PutStorageAction extends ActionSupport
{
    private String goodsId;
    private int goodsCount;
    private String storage;
    private long totalCount;
    private int status;
    private String message;

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

    public int getGoodsCount()
    {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount)
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

    @Override
    public String execute() throws Exception
    {
        long fullStorage=0;   //仓库最大总数量����������
        long currentNum=0;    //仓库当前存储量�
        long goodsCount=0;    //货物当前数量;
        if((int)ActionContext.getContext().getSession().get("role")==2)
        {

            if (getStorage().equals("A"))
            {
                String sql_full = "select fullStorage from StorageA where goodsId=?";
                String sql_current = "select currentNum from StorageA where goodsId=?";
                String sql_goodsCount="select goodsCount from StorageA where goodsId=?";
                String sql="update storagea set currentNum=?,goodsCount=? where goodsId=?";

                DBTemplate<StorageA> db_A1 = new DBTemplate<>();
                fullStorage = db_A1.loadEntityBySql(sql_full,getGoodsId());
                DBTemplate<StorageA> db_A2 = new DBTemplate<>();
                currentNum = db_A2.loadEntityBySql(sql_current,getGoodsId());
                DBTemplate<StorageA> db_A4 = new DBTemplate<>();
                goodsCount=db_A4.loadEntityBySql(sql_goodsCount,getGoodsId());
                DBTemplate<StorageA> db_A3 = new DBTemplate<>();
                if (fullStorage < (currentNum + getGoodsCount()))
                {
                    status = -200;
                    message = "仓库已满";
                    ActionContext.getContext().getSession().put("message",message);
                    ActionContext.getContext().getSession().put("status",status);
                }
                else
                {

                    long new_currentnum=currentNum + getGoodsCount();
                    long new_goodsCount=goodsCount+getGoodsCount();


                    if (db_A3.updateEntityById(sql,new_currentnum,new_goodsCount,getGoodsId())> 0)
                    {
                        status = 100;
                        message = "添加成功";
                        ActionContext.getContext().getSession().put("message",message);
                        ActionContext.getContext().getSession().put("status",status);
                    }
                }
            }
            else if (getStorage().equals("B"))
            {
                String sql_full = "select fullStorage from StorageB";
                String sql_current = "select currentNum from StorageB";
                String sql_goodsCount="select goodsCount from StorageA where goodsId=?";
                String sql="update storageb set currentNum=?,goodsCount=? where goodsId=?";
                StorageB storageB = new StorageB();

                DBTemplate<StorageB> db_B1 = new DBTemplate<>();
                fullStorage = db_B1.loadEntityBySql(sql_full);
                DBTemplate<StorageA> db_B2 = new DBTemplate<>();
                currentNum = db_B2.loadEntityBySql(sql_current);
                DBTemplate<StorageB> db_B4 = new DBTemplate<>();
                goodsCount=db_B4.loadEntityBySql(sql_goodsCount,getGoodsId());
                DBTemplate<StorageB> db_B3 = new DBTemplate<>();
                if (fullStorage < (currentNum + getGoodsCount()))
                {
                    status = -200;
                    message = "仓库已满";
                    ActionContext.getContext().getSession().put("message",message);
                    ActionContext.getContext().getSession().put("status",status);
                }
                else
                {
                    long new_currentnum=currentNum + getGoodsCount();
                    long new_goodsCount=goodsCount+getGoodsCount();

                    if (db_B3.updateEntityById(sql,new_currentnum,new_goodsCount,getGoodsId())> 0)
                    {
                        status = 100;
                        message = "添加成功";
                        ActionContext.getContext().getSession().put("message",message);
                        ActionContext.getContext().getSession().put("status",status);
                    }
                }
            }
            else if (getStorage().equals("C"))
            {
                String sql_full = "select fullStorage from StorageC";
                String sql_current = "select currentNum from StorageC";
                String sql_goodsCount="select goodsCount from StorageA where goodsId=?";
                String sql="update storagec set currentNum=?,goodsCount=? where goodsId=?";
                StorageC storageC = new StorageC();

                DBTemplate<StorageC> db_C1 = new DBTemplate<>();
                fullStorage = db_C1.loadEntityBySql(sql_full);
                DBTemplate<StorageC> db_C2 = new DBTemplate<>();
                currentNum = db_C2.loadEntityBySql(sql_current);
                DBTemplate<StorageC> db_C4 = new DBTemplate<>();
                goodsCount=db_C4.loadEntityBySql(sql_goodsCount,getGoodsId());
                DBTemplate<StorageC> db_C3 = new DBTemplate<>();
                if (fullStorage < (currentNum + getGoodsCount()))
                {
                    status = -200;
                    message = "仓库已满";
                    ActionContext.getContext().getSession().put("message",message);
                    ActionContext.getContext().getSession().put("status",status);
                }
                else
                {
                    long new_currentnum=currentNum + getGoodsCount();
                    long new_goodsCount=goodsCount+getGoodsCount();

                    if (db_C3.updateEntityById(sql,new_currentnum, new_goodsCount, getGoodsId()) > 0)
                    {
                        status = 10000;
                        message = "添加";
                        ActionContext.getContext().getSession().put("message",message);
                        ActionContext.getContext().getSession().put("status",status);
                    }
                }
            }
        }else {
            status=-100;
            message="权限不足";
            ActionContext.getContext().getSession().put("message",message);
            ActionContext.getContext().getSession().put("status",status);
        }
        return SUCCESS;
    }
}
