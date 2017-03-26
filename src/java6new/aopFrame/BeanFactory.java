package java6new.aopFrame;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/26 0026 11:49
 */
public class BeanFactory {

    Properties props = new Properties();

    public BeanFactory(InputStream ips) {

        try {
            props.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name){

        String className = props.getProperty(name);
        Object retBean=null;
        try {
            Class clazz = Class.forName(className);
            Object bean = clazz.newInstance();

            if(bean instanceof ProxyFactoryBean){
                Object proxy;
                try {
                    ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) bean;
                    Advice advice = (Advice) Class.forName(props.getProperty(name + ".advice")).newInstance();
                    Object target = Class.forName(props.getProperty(name + ".target")).newInstance();
                    proxyFactoryBean.setAdvice(advice);
                    proxyFactoryBean.setTarget(target);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                proxy = ((ProxyFactoryBean) bean).getProxy();
                return proxy;
            }
            retBean = bean;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retBean;
    }
}
