package com.drugsystem.bean.daobean;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/3.
 */
@Entity
public class Client implements Serializable{

    private int client_id;                    //客户ID
    private String client_name;               //客户姓名
    private int client_phone;                 //客户电话
    private String client_address;            //客户地址

    @Id
    @GeneratedValue
    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(int client_phone) {
        this.client_phone = client_phone;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }
}
