package com.drugsystem.action;

import com.drugsystem.dao.DBTemplate;
import com.drugsystem.model.DrugAdministrator;
import com.drugsystem.model.Libaray;
import com.drugsystem.model.SystemAdministrator;
import com.drugsystem.model.WareHouse;
import com.drugsystem.service.LoginService;
import com.drugsystem.util.Status;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.jboss.logging.Logger;


/**
 * Created by Administrator on 2015/11/3.
 * 锟斤拷录模锟斤拷
 */
public class LoginAction extends ActionSupport
{
    private String uid;
    private String password;
    private int status;
    private String message;
    private Logger logger = Logger.getLogger(LoginAction.class);

    public String getUid()
    {
        return uid;
    }

    public void setUid(String username)
    {
        this.uid = username;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String execute() throws Exception
    {
        logger.info("Start Login Action");
        System.out.println("Start Login Action");
        System.out.println("UID-----"+getUid());
        System.out.println("PASSWORD-----"+getPassword());
        String roleName = "";
        String name = "";

     //   if (ActionContext.getContext().getSession().get("name") == null)
    //    {
            if ((status = LoginService.login(getUid(), getPassword())) > 0)
            {
                System.out.println("status111-----"+status);
                if (status == 1)
                {
                    DBTemplate<DrugAdministrator> db_drug = new DBTemplate<DrugAdministrator>();
                    DrugAdministrator drug = db_drug.loadEntity(DrugAdministrator.class, getUid());
                    name = drug.getName();
                    roleName = drug.getRoleName();
                    ActionContext.getContext().getSession().put("role", 1);
                    ActionContext.getContext().getSession().put("uid", getUid());
                    ActionContext.getContext().getSession().put("name", name);
                    return "drugAdministrator";
                }
                else if (status == 2)
                {
                    DBTemplate<Libaray> db_libaray = new DBTemplate<>();
                    Libaray libaray = db_libaray.loadEntity(Libaray.class, getUid());
                    name = libaray.getName();
                    roleName = libaray.getRoleName();
                    ActionContext.getContext().getSession().put("role", 2);
                    ActionContext.getContext().getSession().put("uid", getUid());
                    ActionContext.getContext().getSession().put("name", name);
                    return "libaray";
                }
                else if (status == 3)
                {

                   DBTemplate<SystemAdministrator> db_system = new DBTemplate<>();
                    SystemAdministrator system = db_system.loadEntity(SystemAdministrator.class, getUid());
                    name = system.getName();
                    roleName = system.getRoleName();
                    ActionContext.getContext().getSession().put("role", 3);
                    ActionContext.getContext().getSession().put("uid", getUid());
                    ActionContext.getContext().getSession().put("name", name);
                    return "systemAdministrator";
                }
                else if (status == 4)
                {
                    DBTemplate<WareHouse> db_ware = new DBTemplate<>();
                    WareHouse wareHouse = db_ware.loadEntity(WareHouse.class, getUid());
                    name = wareHouse.getName();
                    roleName = wareHouse.getRoleName();
                    ActionContext.getContext().getSession().put("role", 4);
                    ActionContext.getContext().getSession().put("uid", getUid());
                    ActionContext.getContext().getSession().put("name", name);
                    return "wareHouse";
                }

            }
            else
            {

                status = -100;
                message = "鐢ㄦ埛涓嶅瓨鍦�";
                return ERROR;
            }
      //  }
    /*    else
        {
            status = -300;
            message = "鐢ㄦ埛鏈縺娲�";
            return ERROR;
        }
        */
        System.out.println("status---------" + status);
        System.out.println("message---------" + message);

        return SUCCESS;
    }

    /**
     * 锟斤拷录锟斤拷
     * @return
     */
    public String logout(){
        logger.info("start logout");
        try{
            ActionContext.getContext().getSession().remove("uid");
            ActionContext.getContext().getSession().remove("name");
            ActionContext.getContext().getSession().remove("role");
            ActionContext.getContext().getSession().remove("roleName");
            logger.info("Logout Success");
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            logger.info("Logout Error");
            return ERROR;
        }
    }
}
