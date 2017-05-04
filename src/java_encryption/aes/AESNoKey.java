package java_encryption.aes;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Created by hzqiuxm on 2016/4/14 0014.
 * 使用种子生成可控的秘钥，这样就不需要保存加解密密钥了
 */
public class AESNoKey {

    public static void main(String[] args) throws Exception{

        String inputStr = "AES";
        String mystr = "123";
        byte[] inputSeed = mystr.getBytes();
        byte[] inputData = inputStr.getBytes();

        System.err.println("原文:\t" + inputStr);

        // 加密操作步骤
        //第一步：获取一个密钥生成器
        KeyGenerator kgAES = KeyGenerator.getInstance("AES");
        SecureRandom e = SecureRandom.getInstance("SHA1PRNG");
        System.out.println("e = "+e);
        e.setSeed(inputSeed);
        //第二步：密钥生成器初始化
        kgAES.init(128, e);
        //第三步：获得一个基本密钥并编码
        SecretKey secretKey = kgAES.generateKey();
        byte[] skEncode = secretKey.getEncoded();
        System.out.println("秘钥： "+Base64.encodeBase64String(skEncode));
        //第四步：构造出一个可以用于AES算法的密钥
        SecretKeySpec key = new SecretKeySpec(skEncode, "AES");
        //第五步：创建一个AES密码器，密码器是用于实际加解密操作的
        Cipher cipher = Cipher.getInstance("AES");
        //第六步：1代表使用加密的方式初始化密码器
        cipher.init(1, key);
        //第七步：进行加密
        byte[] outputData = cipher.doFinal(inputData);
        String strOutput = Base64.encodeBase64String(outputData);
        System.out.println("密文：" + strOutput);


        //解密步骤
        //第一步：获取一个密钥生成器
        KeyGenerator kgAES2 = KeyGenerator.getInstance("AES");
        SecureRandom e2 = SecureRandom.getInstance("SHA1PRNG");
        e2.setSeed(inputSeed);
        //第二步：密钥生成器初始化
        kgAES2.init(128, e2);
        //第三步：获得一个基本密钥并编码
        SecretKey secretKey2 = kgAES2.generateKey();
        byte[] skEncode2 = secretKey2.getEncoded();
        System.out.println("秘钥2： "+Base64.encodeBase64String(skEncode2));
        //第四步：构造出一个可以用于AES算法的密钥
        SecretKeySpec key2 = new SecretKeySpec(skEncode2, "AES");
        //第五步：创建一个AES密码器，密码器是用于实际加解密操作的
        Cipher cipher2 = Cipher.getInstance("AES");
        //第六步：2代表使用解密的方式初始化密码器
        cipher2.init(2, key2);

        System.err.println("明文：" + new String(cipher2.doFinal(outputData)));
    }

}
