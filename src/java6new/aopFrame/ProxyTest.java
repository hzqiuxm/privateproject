package java6new.aopFrame;

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

        //用Proxy直接一步创建
        final ArrayList target = new ArrayList();
        Advice advice = new MyAdvice();

        Collection proxy3 = (Collection) getProxy(target,advice);

        proxy3.add("hzqiuxm");
        proxy3.add("临江仙");
        proxy3.add("菡萏如佳人");

    }

    //这个方法就是一个黑匣子,可以交给第三方人员使用,就像我们使用spring框架那样,一般开发人员都是写advice对象就行了
    private static Object getProxy(final Object target,final Advice advice) {
        return Proxy.newProxyInstance(
                    target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                            advice.beforeMethod(method);
                            Object obj = method.invoke(target,args);
                            advice.afterMethod(method);

                            return obj;
                        }
                    }
            );
    }


}
