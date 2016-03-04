package com.drugsystem.service;

import com.drugsystem.util.Status;
import com.drugsystem.util.Validate;

/**
 * Created by Administrator on 2015/11/21.
 */
public class LoginService
{
    public static int login(String uid,String pass){
        int status=0;
        if((status= Validate.validate(uid,pass, Status.ROLE_Drug))>0){
           // return Status.ROLE_Drug;
            status=Status.ROLE_Drug;
        }
        else if ((status=Validate.validate(uid,pass,Status.ROLE_Libaray))>0){
          //  return Status.ROLE_Libaray;
            status=Status.ROLE_Libaray;
        }
        else if ((status=Validate.validate(uid,pass,Status.ROLE_System))>0){
           // return Status.ROLE_System;
            status=Status.ROLE_System;
        }
        else if ((status=Validate.validate(uid,pass,Status.ROLE_WareHouse))>0){
          //  return Status.ROLE_WareHouse;
            status=Status.ROLE_WareHouse;
        }
        return status;
    }
}
