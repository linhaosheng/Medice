package com.drugsystem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Administrator on 2015/11/3.
 */
public class DBManager {

    public static DBManager dbManager=null;
    public Session session=null;
    public static DBManager getInstance(){
        if(dbManager==null){
            dbManager=new DBManager();
        }
        return dbManager;
    }
    private static  SessionFactory factory=null;
    private static  ServiceRegistry registry=null;

    //实例化factory
     public  void getSessionFactory(){
         Configuration configuration=new Configuration();
         configuration.configure();

         registry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
         factory=configuration.buildSessionFactory(registry);
     }

    //打开session
    public  org.hibernate.Session getSession(){
        getSessionFactory();
         session= factory.openSession();
        return session;
    }
   //关闭factory
    public void close(){
        if(session!=null){
            session.close();
        }
        if(factory!=null){
            factory.close();
        }
    }
}
