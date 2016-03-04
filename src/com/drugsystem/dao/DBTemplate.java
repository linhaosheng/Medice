package com.drugsystem.dao;

import com.drugsystem.bean.daobean.GoodsInfo;
import com.drugsystem.model.Libaray;
import com.drugsystem.model.Page;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2015/11/3.
 */

public class DBTemplate<T> implements BaseDao<T>{

    private Class cls;
    private DBManager dbManager=null;
    private Session session=null;
  //  private  DBTemplate<T> dbTemplate=null;
    /**
     * ???????????
     */
    private boolean isTransaction=false;

    public DBTemplate(){
        dbManager=DBManager.getInstance();
        dbManager.getSessionFactory();
        session=dbManager.getSession();

    }

   /* public  DBTemplate getInstance(){
        if(dbTemplate==null){
            dbTemplate=new DBTemplate();
        }
        return dbTemplate;
    }
*/
    //????
    @Override
    public int  saveEntity(Object e) {
        session.beginTransaction();
        int isSuccess;
        try {
            session.save(e);
            isSuccess=1;
            session.getTransaction().commit();
        }catch (Exception i){
            i.printStackTrace();
            isSuccess=-1;
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return isSuccess;
    }

    @Override
    public int saveEntityById(T e, String goodsId)
    {
        session.beginTransaction();
        int isSuccess;
        try {
            session.save(goodsId,e);
            isSuccess=1;
            session.getTransaction().commit();
        }catch (Exception i){
            i.printStackTrace();
            isSuccess=-1;
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return isSuccess;
    }

    //????
    @Override
    public void updateEntity(T e) {

        session.beginTransaction();
        try{
            session.update(e);
            session.getTransaction().commit();
        }catch (Exception i){
            i.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
    }

    @Override
    public int updateEntityById(String sql,long current,long goodsCount,String goodsId)
    {
        int isSuccess=0;
        session.beginTransaction();

        try{
            Query query=session.createQuery(sql);
            query.setLong(0,current);
            query.setLong(1,goodsCount);
            query.setString(2,goodsId);
            isSuccess=1;
            session.getTransaction().commit();
        }catch (Exception i){
            i.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return isSuccess;
    }


    //????????
    @Override
    public void updateAllEntity(List<T> object) {
        session.beginTransaction();
        try{
            for (int i=0;i<object.size();i++){
                session.update(object.get(i));
            }
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
    }

    //???
    @Override
    public void deleteEntity(T e) {

        session.beginTransaction();
        try {
            session.delete(e);
            session.getTransaction().commit();
        }catch (Exception i){
            i.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
    }

    //????ID???
    @Override
    public void deleteEntityById(Class c ,Serializable id) {

        session.beginTransaction();
        try{
            session.delete(session.load(c,id));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
    }

    //???????
    @Override
    public T loadEntity(Class<T> tClass, Serializable id) {
        session.beginTransaction();
        T t=null;
        try{
          t=(T)session.get(tClass, id);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return t;
    }

    @Override
    public T loadEntityById(Serializable id) {
      return (T)loadEntity(cls,id);
    }


    @Override
    public List<GoodsInfo> loadAllEntity()
    {
        session.beginTransaction();
        List<GoodsInfo>list=null;
        try
        {
           Query query= session.createQuery("from GoodsInfo");
            list=query.list();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally
        {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return null;
    }

    @Override
    public List<T> loadAllEntity(Class cls)
    {
        session.beginTransaction();
        List<T>list=null;
        try
        {
          Criteria criteria= session.createCriteria(cls);
            list=criteria.list();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally
        {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return null;
    }

    @Override
    public List<T> loadListEntities(Page page) {
        List<T>list=new ArrayList<T>();
        session.beginTransaction();
        try{
           Long total=(Long) session.createQuery("select count(*) from " + page.getDaoBeanName()).uniqueResult();
            page.setTotalCount(total.intValue());
            list=  session.createQuery("from "+page.getDaoBeanName())
                    .setFirstResult((page.getPageNow()-1)*page.getPageSize())
                    .setMaxResults(page.getPageSize()).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return list;
    }

    @Override
    public long loadEntityBySql(String sql)
    {
        session.beginTransaction();
        try{
             Query query= session.createQuery(sql);
             long num=((Number)query.iterate().next()).longValue();
             return  num;
        }catch (Exception e){
            e.printStackTrace();
        }finally
        {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return 0;
    }

    @Override
    public long  loadEntityBySql(String sql, String num)
    {
        session.beginTransaction();
        try{
            Query query=session.createQuery(sql);
            query.setString(0,num);
            long numGoods=((Number)query.iterate().next()).longValue();
            return numGoods;
        }catch (Exception e){
            e.printStackTrace();
        }finally
        {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return 0;
    }

    public int loadNum(){
        session.beginTransaction();
        try
        {
           Query query= session.createQuery("select count(*) from goodsInfo");
            int num=((Number)query.iterate().next()).intValue();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally
        {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return 0;
    }
    /*
    public <T> void save(T object){
      session.beginTransaction();
        try {
            session.save(object);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
    }


    public <T>void delete(T object){
        session.beginTransaction();
        try {
            session.delete(object);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
    }


    public void deleteById(Class c,int id){
        session.beginTransaction();
        try{
            session.delete(session.load(c,id));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
    }


    public <T>void update(T object){
        session.beginTransaction();
        try{
            session.update(object);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
    }


    public <T>void  updateALL(List<T> object){
      session.beginTransaction();
        try{
            for (int i=0;i<object.size();i++){
                session.update(object.get(i));
            }
          session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
    }


    public <T> List<T> queryALL(Class c,String table){
        session.beginTransaction();
        List<T>list=null;
        try{
           Query query= session.createSQLQuery("select * from " + table).addEntity(c.getClass());
            list=query.list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return list;
    }


    public <T> T queryById(Class c,int id){
        List<T>list=null;
        T t=null;
        session.beginTransaction();
        try{
          t=(T)session.get(c,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return t;
    }


    public <T> List<T> queryForList(Class object ,int start,int max){
        session.beginTransaction();
        List list=new ArrayList<>();
        try {
              StringBuffer string=new StringBuffer();
            string.append("from").append(object.getClass()).append("as object");
            Query query=session.createQuery(string.toString());
            query.setFirstResult(start);
            query.setMaxResults(max);
             list=   query.list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return list;
    }
*/
    /**
     * ??????????????
     * @param loginUser
     * @return
     */
  /*  public LoginUser checkLogin(LoginUser loginUser){
        session.beginTransaction();
        LoginUser loginUser1=null;
        try{

         Criteria criteria= session.createCriteria(LoginUser.class).add(Example.create(loginUser));
            loginUser1=(LoginUser)criteria.list().get(0);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!isTransaction){
                dbManager.close();
            }
        }
        return loginUser1;
    }
    */
}
