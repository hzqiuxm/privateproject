package java6new;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/20 0020 10:06
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

   /*     ReflectPoint pt1 = new ReflectPoint(3,5);
        //公有变量的获取方法
        Field fieldY = pt1.getClass().getField("y");
        //fieldY的值是多少要决定于它代表的是哪个对象实例，它本身是类上的
        System.out.println(fieldY.get(pt1));

        //私有变量的获取方法,暴力反射
        Field fieldX = pt1.getClass().getDeclaredField("x");
        fieldX.setAccessible(true);
        System.out.println(fieldX.get(pt1));

        changeStringValue(pt1);*/

        //配置文件路径最好用完整的绝对路径
        InputStream ips = new FileInputStream("config/config.properties");

        Properties props = new Properties();
        props.load(ips);
        ips.close();

        String className = props.getProperty("className");


//        Collection collections = new HashSet();
        Collection collections = (Collection) Class.forName(className).newInstance();

        ReflectPoint pt1 = new ReflectPoint(3,3);
        ReflectPoint pt2 = new ReflectPoint(5,5);
        ReflectPoint pt3 = new ReflectPoint(3,3);

        //HashSet不存放相同的数据
        collections.add(pt1);
        collections.add(pt2);
        collections.add(pt3);


//        pt3.setX(10);
//        collections.remove(pt3);

        System.out.println(collections.size());

    }

    private static void changeStringValue(Object obj) throws Exception{

        Field[] fields = obj.getClass().getFields();
        for (Field field : fields){
            if(field.getType() == String.class){
                String oldValue = (String)field.get(obj);
                String newValue = oldValue.replace('b','a');
                field.set(obj,newValue);
            }
        }

        System.out.println(obj);
    }


}
