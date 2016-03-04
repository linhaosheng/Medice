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

    private ByteArrayInputStream image;   //图片
    private String str;   //验证码
    private static RandomNumUtil randomNumUtil;
    public RandomNumUtil(){
        init();
    }

    //获取RandomNumUtil的单例
    public static RandomNumUtil getInstance(){
        if(randomNumUtil==null){
            randomNumUtil=new RandomNumUtil();
        }
        return randomNumUtil;
    }

    //取得验证码图片
    public ByteArrayInputStream getImage(){
        return this.image;
    }

    //取得图片的验证码
    public String getStr(){
        return this.str;
    }

    public void init(){
       //在内存中创建图像
        int width=65;
        int height=20;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //获取图形上下文
        Graphics graphics=image.getGraphics();
        Random random=new Random();
        // 设定背景色
        graphics.setColor(getRandColor(200,250));
        graphics.fillRect(0,0,width,height);
        //设定字体
        graphics.setFont(new Font("Times New Roman",Font.PLAIN,18));
        // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
        graphics.setColor(getRandColor(160,200));
        for (int i=0;i<155;i++){
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(12);
            int y1=random.nextInt(12);
            graphics.drawLine(x,y,x+x1,y+y1);
        }
        // 取随机产生的认证码(4位数字)
        String strRand="";

        //写字母
        String content = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcedfghijklmnopqrstuvwxyz1234567890";
        for(int i=0;i<4;i++){
            int index = random.nextInt(content.length());
            String  rand= String.valueOf(content.charAt(index)).toString();
            strRand+=rand;

            // 将认证码显示到图象中
            graphics.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            graphics.drawString(rand,13*i+6,16);
        }
        //赋值验证码
        this.str=strRand;
        //图像生效
        graphics.dispose();
        ByteArrayInputStream input=null;
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try{
            ImageOutputStream imageOutput= ImageIO.createImageOutputStream(out);
            ImageIO.write(image,"JPEG",imageOutput);
            imageOutput.close();
            input=new ByteArrayInputStream(out.toByteArray());
        }catch (Exception e){
            System.out.println("验证码图片产生出现错误："+e.toString());
        }
        this.image=input;
    }

    /**
     * 给定范围获得随机颜色
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
