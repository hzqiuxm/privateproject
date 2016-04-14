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

        // 加密
        KeyGenerator kgAES = KeyGenerator.getInstance("AES");
        SecureRandom e = SecureRandom.getInstance("SHA1PRNG");
        System.out.println("e = "+e);
        e.setSeed(inputSeed);
        kgAES.init(128, e);
        SecretKey secretKey = kgAES.generateKey();
        byte[] skEncode = secretKey.getEncoded();
        System.out.println("秘钥： "+Base64.encodeBase64String(skEncode));
        SecretKeySpec key = new SecretKeySpec(skEncode, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, key);

        byte[] outputData = cipher.doFinal(inputData);
        String strOutput = Base64.encodeBase64String(outputData);
        System.out.println("密文：" + strOutput);


        //解密
        KeyGenerator kgAES2 = KeyGenerator.getInstance("AES");
        SecureRandom e2 = SecureRandom.getInstance("SHA1PRNG");
        e2.setSeed(inputSeed);
        kgAES2.init(128, e2);
        SecretKey secretKey2 = kgAES2.generateKey();
        byte[] skEncode2 = secretKey2.getEncoded();
        System.out.println("秘钥2： "+Base64.encodeBase64String(skEncode2));
        SecretKeySpec key2 = new SecretKeySpec(skEncode2, "AES");
        Cipher cipher2 = Cipher.getInstance("AES");
        cipher2.init(2, key2);

        System.err.println("明文：" + new String(cipher2.doFinal(outputData)));
    }

}
