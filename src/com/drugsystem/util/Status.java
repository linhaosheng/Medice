package com.drugsystem.util;

/**
 * Created by Administrator on 2015/11/21.
 */
public class Status
{
    public static final int SUCCESS=100;

    public static final int USER_NOT_ACTIVE = -300;
    public static final int USER_PASS_ERROR = -200;
    public static final int USER_NOT_EXIST = -100;
    public static final int INNER_ERROR=-1000;      //�ڲ�����

    public static final int ROLE_Drug= 1;          //  ҩƷ����Ա
    public static final int ROLE_Libaray = 2;      //����Ա
    public static final int ROLE_System= 3;       //ϵͳ����Ա
    public static final int ROLE_WareHouse= 4;    // ���Ա
}
