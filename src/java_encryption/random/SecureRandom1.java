package java_encryption.random;

import org.junit.Test;

import java.security.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/3 0003 18:43
 */
public class SecureRandom1 {

    public static void main(String[] args) throws Exception {

        SecureRandom secureRandom  = new SecureRandom();
        byte bytes[] = new byte[20];

        System.out.println(secureRandom.nextInt(10));

//        Signature jdksignature = Signature.getInstance("SHA256withRSA");
//        signatureTest();

    }

    /**
     * 数字签名处理示例
     * JDK自带数字签名实现
     * @throws Exception
     */
    public static void signatureTest() throws Exception {

        byte[] data = "Data Signature".getBytes();
        KeyPairGenerator jdkkeygen = KeyPairGenerator.getInstance("DSA");
        jdkkeygen.initialize(1024);
        KeyPair keyPair = jdkkeygen.generateKeyPair();
        Signature signature = Signature.getInstance(jdkkeygen.getAlgorithm());
        //初始化用于签名操作的Signature对象
        signature.initSign(keyPair.getPrivate());
        signature.update(data);

        byte[] sign = signature.sign();
        System.out.println("私钥签名：" + sign);

        signature.initVerify(keyPair.getPublic());
        signature.update(data);
        boolean verify = signature.verify(sign);
        System.out.println("验证结果： " + verify);


    }

    @Test
    public final void testSecureRandom(){
        SecureRandom secureRandom  = new SecureRandom();
        byte bytes[] = new byte[20];

        System.out.println(secureRandom.nextInt());

    }
}
