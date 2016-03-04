package com.drugsystem.dao;

import com.drugsystem.bean.daobean.GoodsInfo;
import com.drugsystem.model.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/11/4.
 */
public interface BaseDao <T>{

    public int saveEntity(T e);

    public int saveEntityById(T e,String goodsId);

    public void updateEntity(T e);

    public int  updateEntityById(String sql,long current,long goodsCount,String goodsId);

    public void updateAllEntity(List<T> object);

    public void deleteEntity(T e);

    public void deleteEntityById(Class c,Serializable id);

    public T loadEntity(final Class<T> tClass,final Serializable id);

    public T loadEntityById(Serializable id);

    public long loadEntityBySql(String sql);

    public List<GoodsInfo> loadAllEntity();

    public List<T> loadAllEntity(Class c);

    public List<T> loadListEntities(Page page);

    public long loadEntityBySql(String sql,String num);
}
