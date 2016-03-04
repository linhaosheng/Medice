package com.drugsystem.bean.daobean;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2015/11/3.
 */
@Entity
public class GoodsInfo implements Serializable{

    private String goodsId;                   //��ҩƷID
    private String goodsName;             //��ҩƷ����
    private String  unit;                //��浥λ
    private int stock_number;            //��ҩƷ����
    private String contact;             //����Ӧ��
    private String spec;                //��װ���
    private Timestamp date;            //��ʱ��
    private String tel;                 //�绰
    private long alertValue;          //��澯��ֵ
    private long storageAmount;        //�������
    private String source;             //��Ӧҩ��
    private Supply supply;              //��Ӧ��

    @Id
    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public long getAlertValue()
    {
        return alertValue;
    }

    public void setAlertValue(long alertValue)
    {
        this.alertValue = alertValue;
    }

    public Timestamp getDate()
    {
        return date;
    }

    public void setDate(Timestamp date)
    {
        this.date = date;
    }

    public String getSource()
    {
        return source;
    }

    public String getSpec()
    {
        return spec;
    }

    public void setSpec(String spec)
    {
        this.spec = spec;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public int getStock_number()
    {
        return stock_number;
    }

    public void setStock_number(int stock_number)
    {
        this.stock_number = stock_number;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public long getStorageAmount()
    {
        return storageAmount;
    }

    public void setStorageAmount(long storageAmount)
    {
        this.storageAmount = storageAmount;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    @OneToOne
    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }
}
