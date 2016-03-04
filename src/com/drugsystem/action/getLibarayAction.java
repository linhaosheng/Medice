package com.drugsystem.action;

import com.drugsystem.dao.DBTemplate;
import com.drugsystem.model.Libaray;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class getLibarayAction extends ActionSupport
{
    @Override
    public String execute() throws Exception
    {
         List<Libaray>listLib=new ArrayList<>();
        DBTemplate<Libaray>dbTemplate=new DBTemplate<>();
        List list1=  dbTemplate.loadAllEntity(Libaray.class);
        for(int i=0;i<list1.size();i++){
           Libaray libaray=(Libaray)list1.get(i);
            listLib.add(libaray);
        }
        ActionContext.getContext().getSession().put("listLib",listLib);
        ActionContext.getContext().getSession().put("listSize",list1.size());
        return SUCCESS;
    }
}
