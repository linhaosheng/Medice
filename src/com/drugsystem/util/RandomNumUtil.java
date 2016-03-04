package com.drugsystem.util;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * Created by Administrator on 2015/11/3.
 */
public class RandomNumUtil {

    private ByteArrayInputStream image;   //ͼƬ
    private String str;   //��֤��
    private static RandomNumUtil randomNumUtil;
    public RandomNumUtil(){
        init();
    }

    //��ȡRandomNumUtil�ĵ���
    public static RandomNumUtil getInstance(){
        if(randomNumUtil==null){
            randomNumUtil=new RandomNumUtil();
        }
        return randomNumUtil;
    }

    //ȡ����֤��ͼƬ
    public ByteArrayInputStream getImage(){
        return this.image;
    }

    //ȡ��ͼƬ����֤��
    public String getStr(){
        return this.str;
    }

    public void init(){
       //���ڴ��д���ͼ��
        int width=65;
        int height=20;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //��ȡͼ��������
        Graphics graphics=image.getGraphics();
        Random random=new Random();
        // �趨����ɫ
        graphics.setColor(getRandColor(200,250));
        graphics.fillRect(0,0,width,height);
        //�趨����
        graphics.setFont(new Font("Times New Roman",Font.PLAIN,18));
        // �������155�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
        graphics.setColor(getRandColor(160,200));
        for (int i=0;i<155;i++){
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(12);
            int y1=random.nextInt(12);
            graphics.drawLine(x,y,x+x1,y+y1);
        }
        // ȡ�����������֤��(4λ����)
        String strRand="";

        //д��ĸ
        String content = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcedfghijklmnopqrstuvwxyz1234567890";
        for(int i=0;i<4;i++){
            int index = random.nextInt(content.length());
            String  rand= String.valueOf(content.charAt(index)).toString();
            strRand+=rand;

            // ����֤����ʾ��ͼ����
            graphics.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            graphics.drawString(rand,13*i+6,16);
        }
        //��ֵ��֤��
        this.str=strRand;
        //ͼ����Ч
        graphics.dispose();
        ByteArrayInputStream input=null;
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try{
            ImageOutputStream imageOutput= ImageIO.createImageOutputStream(out);
            ImageIO.write(image,"JPEG",imageOutput);
            imageOutput.close();
            input=new ByteArrayInputStream(out.toByteArray());
        }catch (Exception e){
            System.out.println("��֤��ͼƬ�������ִ���"+e.toString());
        }
        this.image=input;
    }

    /**
     * ������Χ��������ɫ
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc,int bc){
        Random random=new Random();
        if(fc>255)
            fc=255;
        if (bc>255)
            bc=255;

        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
}
