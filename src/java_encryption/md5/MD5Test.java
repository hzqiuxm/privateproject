package java_encryption.md5;

import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.Security;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/7 0007 11:15
 */
public class MD5Test {


    //JDK自带实现
    @Test
    public  final void testEncodeMDByJdk() throws Exception{
        byte[]  bytes = "hzqiuxm".getBytes();
        MessageDigest md = MessageDigest.getInstance("MD5");//MD5,SHA-1,SHA-256
        System.out.println((md.digest(bytes)));
    }


    //Bouncycastle实现

    public final void testEncodeMDbyBc() throws Exception{
        byte[] bytes = "hzqiuxm".getBytes();
        Security.addProvider(new BouncyCastlePQCProvider());
        MessageDigest md = MessageDigest.getInstance("MD4");//MD4,MD5,SHA-1,SHA-256

//        System.out.println(Hex.encode(bytes));
        System.out.println(Hex.encode(md.digest(bytes)));
    }
}
