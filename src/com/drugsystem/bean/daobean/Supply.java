package com.drugsystem.bean.daobean;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/3.
 */
@Entity
public class Supply implements Serializable{

    private int supply_id;                     // 供应商ID
    private String supply_name;               //    供应商姓名
    private String supply_address;             //供应商电话
    private String supply_phone;                 //供应商电话

    @Id
    @GeneratedValue
    public int getSupply_id() {
        return supply_id;
    }

    public void setSupply_id(int supply_id) {
        this.supply_id = supply_id;
    }

    public String getSupply_name() {
        return supply_name;
    }

    public void setSupply_name(String supply_name) {
        this.supply_name = supply_name;
    }

    public String getSupply_address() {
        return supply_address;
    }

    public void setSupply_address(String supply_address) {
        this.supply_address = supply_address;
    }

    public String getSupply_phone() {
        return supply_phone;
    }

    public void setSupply_phone(String supply_phone) {
        this.supply_phone = supply_phone;
    }
}
