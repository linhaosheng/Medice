package com.drugsystem.util;

import com.drugsystem.dao.DBTemplate;
import com.drugsystem.model.DrugAdministrator;
import com.drugsystem.model.Libaray;
import com.drugsystem.model.SystemAdministrator;
import com.drugsystem.model.WareHouse;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/11/21.
 */
public class Validate
{

    public static int validate(String uid, String pass, int role)
    {
        switch (role)
        {
            case Status.ROLE_System:
                DBTemplate<SystemAdministrator> db_system = new DBTemplate<>();
                SystemAdministrator system = db_system.loadEntity(SystemAdministrator.class,uid);
                if (system != null)
                {
                    if (system.getStatus() > 0)
                    {
                        if (system.getPassword().equals(pass))
                        {
                            DBTemplate<SystemAdministrator> db_system1 = new DBTemplate<>();
                            system.setLastLogin(new Timestamp(System.currentTimeMillis()));
                            db_system1.updateEntity(system);
                            return Status.SUCCESS;
                        }
                        else
                        {
                            return Status.USER_PASS_ERROR;
                        }
                    }
                    else
                    {
                        return Status.USER_NOT_ACTIVE;
                    }
                }
                else
                {
                    return Status.USER_NOT_EXIST;
                }

            case Status.ROLE_Drug:
                DBTemplate<DrugAdministrator> db_drug = new DBTemplate<>();
                DrugAdministrator drug = db_drug.loadEntity(DrugAdministrator.class, uid);
                if (drug != null)
                {
                    if (drug.getStatus() > 0)
                    {
                        if (drug.getPassword().equals(pass))
                        {
                            DBTemplate<DrugAdministrator> db_drug1 = new DBTemplate<>();
                            drug.setLastLogin(new Timestamp(System.currentTimeMillis()));
                            db_drug1.updateEntity(drug);
                            return Status.SUCCESS;
                        }
                        else
                        {
                            return Status.USER_PASS_ERROR;
                        }
                    }
                    else
                    {
                        return Status.USER_NOT_ACTIVE;
                    }
                }
                else
                {
                    return Status.USER_NOT_EXIST;
                }

            case Status.ROLE_Libaray:
                DBTemplate<Libaray> db_libaray = new DBTemplate<>();
                Libaray libaray = db_libaray.loadEntity(Libaray.class, uid);
                if (libaray != null)
                {
                    if (libaray.getStatus() > 0)
                    {
                        if (libaray.getPassword().equals(pass))
                        {
                            DBTemplate<Libaray> db_libaray1 = new DBTemplate<>();
                            libaray.setLastLogin(new Timestamp(System.currentTimeMillis()));
                            db_libaray1.updateEntity(libaray);
                            return Status.SUCCESS;
                        }
                        else
                        {
                            return Status.USER_PASS_ERROR;
                        }
                    }
                    else
                    {
                        return Status.USER_NOT_ACTIVE;
                    }
                }
                else
                {
                    return Status.USER_NOT_EXIST;
                }

            case Status.ROLE_WareHouse:
                DBTemplate<WareHouse> db_ware = new DBTemplate<>();
                WareHouse ware = db_ware.loadEntity(WareHouse.class,uid);
                if (ware != null)
                {
                    if (ware.getStatus() > 0)
                    {
                        if (ware.getPassword().equals(pass))
                        {
                            DBTemplate<WareHouse> db_ware1 = new DBTemplate<>();
                            ware.setLastLogin(new Timestamp(System.currentTimeMillis()));
                            db_ware1.updateEntity(ware);
                            return Status.SUCCESS;
                        }
                        else
                        {
                            return Status.USER_PASS_ERROR;
                        }
                    }
                    else
                    {
                        return Status.USER_NOT_ACTIVE;
                    }
                }
                else
                {
                    return Status.USER_NOT_EXIST;
                }

            default:
                return Status.USER_NOT_EXIST;

        }
    }
}
