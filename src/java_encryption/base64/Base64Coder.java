package java_encryption.base64;


import cfca.sadk.org.bouncycastle.util.encoders.Base64;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/7 0007 14:34
 * Base64字符操作组件,基于bouncycastle
 */
public abstract class Base64Coder {

    public final static String ENCODING = "UTF-8";

    /**
     * 编码
     * @param data
     * @return
     * @throws Exception
     */
    public static String encode(String data) throws Exception{

        byte[] bytes = Base64.encode(data.getBytes(ENCODING));
        return new String(bytes,ENCODING);
    }

    /**
     * 解码
     * @param data
     * @return
     * @throws Exception
     */
    public static String decode(String data) throws Exception{

        byte[] bytes = Base64.decode(data.getBytes(ENCODING));
        return  new String(bytes,ENCODING);
    }

}
