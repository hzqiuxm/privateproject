package java_encryption.base64;

import org.junit.Assert;
import org.junit.Test;

import java.util.Base64;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/7 0007 14:41
 */
public class Base64CoderTest {

    //基于bouncycastle
    @Test
    public final void test() throws Exception{

        String inputStr = "hzqiuxm";
        System.out.println("原文：" + inputStr);

        String code = Base64Coder.encode(inputStr);
        System.out.println("Base64编码后：" + code);//aHpxaXV4bQ==

        String outputStr = Base64Coder.decode(code);
        System.out.println("Base64解码后：" + outputStr);

        Assert.assertEquals(inputStr,outputStr);
    }


    //JDK的实现,1.8中新增
    @Test
    public final void testBase64ByJdk8() throws Exception{

        String inputStr = "hzqiuxm";
        System.out.println("原文：" + inputStr);
        byte[] bytes = inputStr.getBytes();

        //编码
        byte[] encode = Base64.getEncoder().encode(bytes);
        System.out.println("Base64编码后：" + new String(encode,"UTF-8"));//aHpxaXV4bQ==

        //解码
        byte[] decode = Base64.getDecoder().decode(encode);
        String outputStr = new String(decode,"UTF-8");
        System.out.println("Base64解码后：" + outputStr);

        Assert.assertEquals(inputStr,outputStr);

    }


}
