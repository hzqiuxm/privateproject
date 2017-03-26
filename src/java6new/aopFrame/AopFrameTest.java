package java6new.aopFrame;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/26 0026 12:52
 */
public class AopFrameTest {

    public static void main(String[] args) throws Exception {

        InputStream ips = new FileInputStream("config/config.properties");
        Object bean = new BeanFactory(ips).getBean("xxx");

        System.out.println(bean.getClass().getName());
    }
}
