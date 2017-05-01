package sdk_cfca.asist;

import cfca.paperless.client.servlet.PaperlessClient;
import cfca.paperless.client.util.Base64;
import cfca.paperless.client.util.IoUtil;
import cfca.paperless.client.util.StringUtil;
import cfca.sadk.algorithm.common.Mechanism;
import cfca.sadk.asn1.pkcs.PKCS12;
import cfca.sadk.lib.crypto.JCrypto;
import cfca.sadk.lib.crypto.Session;
import cfca.sadk.util.P10Request;
import cfca.sadk.x509.certificate.X509Cert;
import sdk_cfca.PaperlessConfig;

import java.security.PrivateKey;

public class testApplyAndDownloadCert {

    static PaperlessClient clientBean = null;

    static PrivateKey privateKey = null;
    static String p10String = null;

    protected static void init() throws Exception {
        clientBean = new PaperlessClient(PaperlessConfig.assistUrl);
        clientBean.initSSLContext(PaperlessConfig.keyStorePath, PaperlessConfig.keyStorePassword, PaperlessConfig.trustStorePath, PaperlessConfig.trustStorePassword);
    }

    public static void main(String[] args) throws Exception {
        init();
        testApplyAndDownloadCert();
    }

    public static void testApplyAndDownloadCert() throws Exception {
        try {
            createP10();
            String result = clientBean.applyAndDownloadCert(getApplyCertStrategyXML(), PaperlessConfig.operatorCode, PaperlessConfig.channelCode);
            String code = StringUtil.getNodeText(result, "Code");
            //返回值Code等于200代表后台处理成功
            if (code.equals("200")) {
                String certData = StringUtil.getXmlField(result, "Cert");
                System.out.println("certData=====" + certData);
                X509Cert cert = new X509Cert(Base64.decode(certData.getBytes()));
                IoUtil.write("./TestData/cert/rsa.cer", cert.getEncoded());
                IoUtil.write("./TestData/cert/rsa.pfx", PKCS12.generatePfx(cert, privateKey, "11111111").getEncoded());

            } else {
                System.out.println(result);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
 
    public static String getApplyCertStrategyXML() throws Exception {

        StringBuilder applyCertStrategyXML = new StringBuilder("<Request>");

        applyCertStrategyXML.append("<CustomerType>1</CustomerType>");//7：个人场景证书
        applyCertStrategyXML.append("<CertLevel>1</CertLevel>");

        applyCertStrategyXML.append("<KeyAlg>RSA</KeyAlg>");
        applyCertStrategyXML.append("<KeyLength>2048</KeyLength>");

        applyCertStrategyXML.append("<UserName>192.168.114.67</UserName>");
        applyCertStrategyXML.append("<IdentificationType>Z</IdentificationType>");
        applyCertStrategyXML.append("<IdentificationNo>872844554</IdentificationNo>");
        applyCertStrategyXML.append("<SelfExtValue></SelfExtValue>");
        applyCertStrategyXML.append("<P10>" + p10String + "</P10>");
        applyCertStrategyXML.append("</Request>");

        return applyCertStrategyXML.toString();
    }
    
    private static void createP10() throws Exception {
        JCrypto.getInstance().initialize(JCrypto.JSOFT_LIB, null);
        Session session = JCrypto.getInstance().openSession(JCrypto.JSOFT_LIB);

        P10Request p10Request = new P10Request(session);
        Mechanism mechanism = new Mechanism(Mechanism.SHA256_RSA);
        byte[] p10 = p10Request.generatePKCS10Request(mechanism, 2048, session);
        privateKey = p10Request.getPrivateKey();
        p10String = new String(p10);
    }
}
