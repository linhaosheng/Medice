package com.drugsystem.bean.daobean;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/11/3.
 */
@Entity
public class Shipment implements Serializable{

    private int shipment_id;                          //��ҩƷID
    private String shipment_name;                     //��ҩƷ����
    private int shipment_number;                      //��ҩƷ����
    private String shipment_supply;                   //���ͻ�
    private String shipment_person;                   //��ʱ��
    private Date shipment_time;                       //������

    private Client client;

    @Id
    @GeneratedValue
    public int getShipment_id() {
        return shipment_id;
    }

    public void setShipment_id(int shipment_id) {
        this.shipment_id = shipment_id;
    }

    public String getShipment_name() {
        return shipment_name;
    }

    public void setShipment_name(String shipment_name) {
        this.shipment_name = shipment_name;
    }

    public int getShipment_number() {
        return shipment_number;
    }

    public void setShipment_number(int shipment_number) {
        this.shipment_number = shipment_number;
    }

    public String getShipment_supply() {
        return shipment_supply;
    }

    public void setShipment_supply(String shipment_supply) {
        this.shipment_supply = shipment_supply;
    }

    public String getShipment_person() {
        return shipment_person;
    }

    public void setShipment_person(String shipment_person) {
        this.shipment_person = shipment_person;
    }

    public Date getShipment_time() {
        return shipment_time;
    }

    public void setShipment_time(Date shipment_time) {
        this.shipment_time = shipment_time;
    }

    @OneToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
