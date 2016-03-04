package Test;

import com.drugsystem.bean.daobean.*;
import com.drugsystem.dao.DBManager;
import com.drugsystem.dao.DBTemplate;
import com.drugsystem.model.DrugAdministrator;
import com.drugsystem.model.Libaray;
import com.drugsystem.model.SystemAdministrator;
import com.drugsystem.model.WareHouse;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/3.
 */
public class Test1 {
    Session session=null;
    DBManager dbManager=DBManager.getInstance();
   // DBTemplate dbTemplate=DBTemplate.getInstance();
    @Before
    public void init(){
         session= dbManager.getSession();
    }
    @Test
    public void save(){
        Client client=new Client();
        client.setClient_address("广东省");
        client.setClient_name("李四");
        client.setClient_phone(123455565);

        session.beginTransaction();

        session.save(client);
        session.getTransaction().commit();

    }
    @Test
    public void supplySave(){
        Supply supply=new Supply();
        supply.setSupply_address("青海省");
        supply.setSupply_name("李进");
        supply.setSupply_phone("2112322121312");
    //    dbTemplate.save(supply);
        DBTemplate<Supply>  db=new DBTemplate<Supply>();
        db.saveEntity(supply);

    }
    @Test
    public void supplyUpdate(){
        Supply supply=new Supply();
        supply.setSupply_id(1);
        supply.setSupply_address("北京");
     //   dbTemplate.update(supply);


    }
    @Test
    public void updateAll(){
        Supply supply=new Supply();
        supply.setSupply_id(2);
        supply.setSupply_address("蒙古");
        supply.setSupply_name("小花");
        supply.setSupply_phone("2122121312");

        Supply supply1=new Supply();
        supply1.setSupply_id(3);
        supply1.setSupply_phone("43232322121312");
        supply1.setSupply_name("林好");
        supply1.setSupply_address("广东省");

        Supply supply2=new Supply();
        supply2.setSupply_id(4);
        supply2.setSupply_address("福建省");
        supply2.setSupply_name("新新");
        supply2.setSupply_phone("2112322121312");
        List<Supply>list=new ArrayList<Supply>();
        list.add(supply);
        list.add(supply1);
        list.add(supply2);
    //    dbTemplate.updateALL(list);
    }

    @Test
    public void login(){
    /*    SystemAdministrator administrator=new SystemAdministrator();
        administrator.setUid("001");
        administrator.setPassword("123");
        administrator.setLastLogin(new Timestamp(System.currentTimeMillis()));
        administrator.setName("张三");
        administrator.setGender("男");
        administrator.setStatus(3);
        administrator.setRoleName("系统管理员");
        DBTemplate<SystemAdministrator>dbTemplate=new DBTemplate<>();
        dbTemplate.saveEntity(administrator);
        */
      /*  DBTemplate<Libaray>dbTemplate=new DBTemplate<>();
        Libaray libaray=new Libaray();
        libaray.setLastLogin(new Timestamp(System.currentTimeMillis()));
        libaray.setRoleName("入库员");
        libaray.setStatus(2);
        libaray.setGender("男");
        libaray.setName("小明");
        libaray.setPassword("123");
        libaray.setUid("002");
        dbTemplate.saveEntity(libaray);
        */
        DBTemplate<WareHouse>dbTemplate=new DBTemplate<>();
        WareHouse wareHouse=new WareHouse();
        wareHouse.setUid("003");
        wareHouse.setLastLogin(new Timestamp(System.currentTimeMillis()));
        wareHouse.setPassword("123");
        wareHouse.setName("小王");
        wareHouse.setRoleName("药品管理员");
        wareHouse.setStatus(1);
        dbTemplate.saveEntity(wareHouse);
    }
    @Test
  public void find(){

     //   DBTemplate<SystemAdministrator>dbTemplate=new DBTemplate<>();
      //  SystemAdministrator administrator= dbTemplate.loadEntityById("001");
    //    SystemAdministrator administrator=dbTemplate.loadEntity(SystemAdministrator.class, "张三");
     //   System.out.println(administrator.getPassword());
        //long a=dbTemplate.loadEntityBySql("select status from SystemAdministrator");
       // System.out.println(a);
    //    DBTemplate<Libaray>dbTemplate=new DBTemplate<>();
        DBTemplate<StorageA>dbTemplate=new DBTemplate<>();
        StorageA storageA=new StorageA();
        storageA.setLowerStorage(100);
        storageA.setCurrentNum(100);
        storageA.setFullStorage(100000);
        storageA.setTotalCount(3);
        StorageGoods storageGoods=new StorageGoods();
        storageGoods.setGoodsId("1111");
        storageGoods.setGoodsCount(10000);
      //  storageA.setStorageGoods(storageGoods);
        dbTemplate.saveEntity(storageA);
  }
     @Test
    public void getNum(){
        DBTemplate<StorageA> adbTemplate=new DBTemplate<>();
         //select totalCount from StorageA where sid=?
         String sql="select totalCount from StorageA where goodsId=?";
         long a= adbTemplate.loadEntityBySql(sql,"211");
             System.out.println(a);
    }
    @Test
    public void update(){
   //     DBTemplate<StorageA>s=new DBTemplate<>();

     //   String sql="update StorageA a set a.currentNum=?,a.goodsCount=? where a.goodsId=?";
     //   s.updateEntityById(sql,"1111",1222,11);
      //   DBTemplate<GoodsInfo> dbTemplate=new DBTemplate<>();
    //  List<GoodsInfo>l=  dbTemplate.loadAllEntity();
    //    for(GoodsInfo goodsInfo:l){
     //       System.out.println(goodsInfo.getAlertValue());
    //    }
        DBTemplate<DrugAdministrator>db=new DBTemplate<>();

         List list=db.loadAllEntity(DrugAdministrator.class);
        for (int i=0;i<list.size(); i++) {

            DrugAdministrator    libaray=(DrugAdministrator)list.get(i);

            System.out.println(libaray.getName());

        }
        System.out.println(list.size());
    }
    @After
    public void close(){
            session.close();
    }
}
