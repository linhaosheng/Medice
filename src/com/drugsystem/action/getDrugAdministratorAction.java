package com.drugsystem.action;

import com.drugsystem.dao.DBTemplate;
import com.drugsystem.model.DrugAdministrator;
import com.drugsystem.model.Libaray;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class getDrugAdministratorAction extends ActionSupport
{
    @Override
    public String execute() throws Exception
    {
        List<DrugAdministrator> listDrug=new ArrayList<>();
        DBTemplate<DrugAdministrator> dbTemplate=new DBTemplate<>();
        List list1=  dbTemplate.loadAllEntity(DrugAdministrator.class);
        for(int i=0;i<list1.size();i++){
            DrugAdministrator libaray=(DrugAdministrator)list1.get(i);
            listDrug.add(libaray);
        }
        ActionContext.getContext().getSession().put("listDrug",listDrug);
        ActionContext.getContext().getSession().put("listSize",list1.size());
        return SUCCESS;
    }
}
