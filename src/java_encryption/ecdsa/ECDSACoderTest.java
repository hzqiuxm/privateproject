package java_encryption.ecdsa;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by hzqiuxm on 2016/3/20 0020.
 */
public class ECDSACoderTest {
    /**
     * 公钥
     */
    private byte[] publicKey;

    /**
     * 私钥
     */
    private byte[] privateKey;

    /**
     * 初始化密钥
     *
     * @throws Exception
     */
    @Before
    public void initKey() throws Exception {

        Map<String, Object> keyMap = ECDSACoder.initKey();

        publicKey = ECDSACoder.getPublicKey(keyMap);

        privateKey = ECDSACoder.getPrivateKey(keyMap);

        System.err.println("公钥: \n" + Base64.encodeBase64String(publicKey));
        System.err.println("私钥： \n" + Base64.encodeBase64String(privateKey));
    }

    /**
     * 校验
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        String inputStr = "ECDSA 数字签名";
        byte[] data = inputStr.getBytes();

        // 产生签名
        long startTIme = System.currentTimeMillis();
        byte[] sign = ECDSACoder.sign(data, privateKey);
        System.err.println("签名:\r" + Hex.encodeHexString(sign));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTIme);
        // 验证签名
        boolean status = ECDSACoder.verify(data, publicKey, sign);
        System.err.println("状态:\r" + status);
        Assert.assertTrue(status);

    }
}
