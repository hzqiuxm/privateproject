package java_encryption.rsa;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by hzqiuxm on 2016/3/20 0020.
 * Rsa签名验证
 */
public class RsaCoderTest {
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

        Map<String, Object> keyMap = RsaCoder.initKey();

        publicKey = RsaCoder.getPublicKey(keyMap);

        privateKey = RsaCoder.getPrivateKey(keyMap);

        System.err.println("公钥: \n" + Base64.encodeBase64String(publicKey));
        System.err.println("私钥： \n" + Base64.encodeBase64String(privateKey));
    }

    /**
     * 校验
     *
     * @throws Exception
     */
    @Test
    public void testSign() throws Exception {

        String inputStr = "Rsa数字签名";
        byte[] data = inputStr.getBytes();

        // 产生签名
        long StartTime = System.currentTimeMillis();
        byte[] sign = RsaCoder.sign(data, privateKey);
        System.err.println("签名:\n" + Hex.encodeHexString(sign));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - StartTime);

        // 验证签名
        boolean status = RsaCoder.verify(data, publicKey, sign);
        System.err.println("状态:\n" + status);
        Assert.assertTrue(status);


    }
}
