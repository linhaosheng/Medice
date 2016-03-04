package com.drugsystem.bean.daobean;

/**
 * Created by Administrator on 2015/11/24.
 */
public class StorageGoods
{
    private String goodsId;       //某一类药品的编码
    private long goodsCount;      //某一类药品的数量
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
