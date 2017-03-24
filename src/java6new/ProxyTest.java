package java6new;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/24 0024 17:25
 */
public class ProxyTest {

    public static void main(String[] args) {

        Class<?> proxyclazz = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(proxyclazz.getName());

        //代理类的构造方法
        System.out.println("------------Begin constructors list------------");
        Constructor[] constructors = proxyclazz.getConstructors();
        for (Constructor constructor : constructors) {

            String name = constructor.getName();
            StringBuilder stringBuilder = new StringBuilder(name);
            stringBuilder.append("(");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class clazz : parameterTypes){
                stringBuilder.append(clazz.getName()).append(',');
            }
            if(parameterTypes.length>0){
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }

            stringBuilder.append(")");
            System.out.println(stringBuilder.toString());
        }

        //代理类的方法
        System.out.println("------------Begin Method list------------");
        Method[] methods = proxyclazz.getMethods();
        for (Method method : methods){
            String name = method.getName();
            StringBuilder stringBuilder = new StringBuilder(name);
            stringBuilder.append("(");
            Class[] parameterTypes = method.getParameterTypes();
            for (Class clazz : parameterTypes){
                stringBuilder.append(clazz.getName()).append(',');
            }
            if(parameterTypes.length>0){
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }

            stringBuilder.append(")");
            System.out.println(stringBuilder.toString());
        }

    }
}
