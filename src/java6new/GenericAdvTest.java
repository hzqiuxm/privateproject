package java6new;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Vector;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/23 0023 20:20
 */
public class GenericAdvTest {

    public static void main(String[] args) throws Exception {

        Object x = "xyz";
        String y = autoConvertType(x);


        //通过方法获得方法参数泛型类型
        Method method = GenericAdvTest.class.getMethod("applyVector",Vector.class);
        Type[] paramTypes = method.getGenericParameterTypes();
        ParameterizedType param = (ParameterizedType)(paramTypes[0]);

        System.out.println(param.getRawType());//Vector
        System.out.println(param.getActualTypeArguments()[0]);//String




    }

    //编写一个泛型方法，自动将Object类型的对象转换成其他类型
    public static <T> T autoConvertType(Object obj){

        return  (T) obj;
    }


    //定义一个方法，可以将任意类型的数组中的所有元素填充为相应类型的某个对象

    public static <T> T[] fill(T[] a, T v) {
        for (int i = 0; i < a.length; i++)
            a[i] = v;
        return a;
    }


    //采用自定泛型方法的方式打印出任意参数化类型的集合中的所有内容

    public static <E> void printCollection(Collection<E> cols) {
        for(E obj:cols) {
            System.out.println(obj);
        }
    }


    //定义一个方法，把任意参数类型的集合中的数据安全地复制到相应类型的数组中

//    static void copy(Collection a, Object[] b);
//static <T> void copy(Collection<T> a,T[] b);
    public  static <T> void copeC2A(Collection<T> dest, T[] src){

    }


    //定义一个方法，把任意参数类型的一个数组中的数据安全地复制到相应类型的另一个数组中
    public  static <T> void copyA2A(T[] dest, T[] src){

    }

    public static void applyVector(Vector<String> v){

    }


}
