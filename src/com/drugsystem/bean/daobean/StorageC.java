package com.drugsystem.bean.daobean;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2015/11/21.
 */

//�ֿ�
@Entity
public class StorageC
{
    private int sid;
    private long totalCount;      //ҩƷ������
    private long currentNum;      //�ֿ⵱ǰ�洢��
    private long fullStorage;    //�ֿ����Ĵ洢����
    private long lowerStorage;    //�ֿ���С�Ĵ洢����

    private String goodsId;
    private long goodsCount;
    public long getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }



    public long getFullStorage()
    {
        return fullStorage;
    }

    public void setFullStorage(long fullStorage)
    {
        this.fullStorage = fullStorage;
    }

    public long getLowerStorage()
    {
        return lowerStorage;
    }

    public void setLowerStorage(long lowerStorage)
    {
        this.lowerStorage = lowerStorage;
    }

    public long getCurrentNum()
    {
        return currentNum;
    }

    public void setCurrentNum(long currentNum)
    {
        this.currentNum = currentNum;
    }

    @Id
    @GeneratedValue
    public int getSid()
    {
        return sid;
    }

    public void setSid(int sid)
    {
        this.sid = sid;
    }

    public long getGoodsCount()
    {
        return goodsCount;
    }

    public void setGoodsCount(long goodsCount)
    {
        this.goodsCount = goodsCount;
    }

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }
}
