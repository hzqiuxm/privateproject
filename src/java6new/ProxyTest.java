package java6new;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/24 0024 17:25
 */
public class ProxyTest {

    public static void main(String[] args) throws Exception {

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
            for (Class clazz : parameterTypes) {
                stringBuilder.append(clazz.getName()).append(',');
            }
            if (parameterTypes.length > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }

            stringBuilder.append(")");
            System.out.println(stringBuilder.toString());
        }

        //代理类的方法
        System.out.println("------------Begin Method list------------");
        Method[] methods = proxyclazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            StringBuilder stringBuilder = new StringBuilder(name);
            stringBuilder.append("(");
            Class[] parameterTypes = method.getParameterTypes();
            for (Class clazz : parameterTypes) {
                stringBuilder.append(clazz.getName()).append(',');
            }
            if (parameterTypes.length > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }

            stringBuilder.append(")");
            System.out.println(stringBuilder.toString());
        }

        //创建实例对象,Collection接口没有无参的构造方法
        System.out.println("------------Begin create instance object------------");
        Constructor<?> constructor = proxyclazz.getConstructor(InvocationHandler.class);

        //内部类写法
        class MyInvocationHander1 implements InvocationHandler {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        }

        Collection proxy1 = (Collection)constructor.newInstance(new MyInvocationHander1());
        System.out.println(proxy1.toString());//初始值为null
        proxy1.clear();
//        proxy1.size(); //有返回值的会报错

        //匿名内部类写法
        Collection proxy2 = (Collection)constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

        //用Proxy直接一步创建
        final ArrayList target = new ArrayList();

        Collection proxy3 = (Collection) getProxy(target);

        proxy3.add("hzqiuxm");
        proxy3.add("临江仙");
        proxy3.add("菡萏如佳人");
        System.out.println(proxy3.size());
        System.out.println(proxy3.getClass().getName());

    }

    private static Object getProxy(final Object target) {
        return Proxy.newProxyInstance(
                    target.getClass().getClassLoader(),
//                    new Class[]{Collection.class},
                    target.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                            long beginTime = System.currentTimeMillis();
                            Object obj = method.invoke(target,args);
                            long endTime = System.currentTimeMillis();

                            System.out.println(method.getName() + "run as time : " + (endTime-beginTime));
                            return obj;
                        }
                    }
            );
    }


}
