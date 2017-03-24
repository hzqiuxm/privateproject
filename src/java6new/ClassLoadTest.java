package java6new;

import java.util.Date;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/24 0024 9:21
 */
public class ClassLoadTest {



    public static void main(String[] args) throws Exception{

//        //查看某类是由哪个类加载器加载的
        System.out.println(ClassLoadTest.class.getClassLoader().getClass().getName());//sun.misc.Launcher$AppClassLoader

//        System.out.println(System.class.getClassLoader().getClass().getName());//空指针异常，表示该类是由BootStrap加载器加载的


//        System.out.println(new ClassLoaderAttr().toString());

        String classPath = "D:\\Dev\\project\\privateproject\\mylib";

        Class clazz = new MyClassLoader(classPath).loadClass("ClassLoaderAttr");


        Date d1 = (Date)clazz.newInstance();

        System.out.println(d1.toString());
    }

}
