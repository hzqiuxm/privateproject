package sdk_cfca;

import cfca.paperless.client.bean.SealUserInfo;
import cfca.paperless.client.bean.SignLocation;
import cfca.paperless.client.servlet.PaperlessClient;
import cfca.paperless.client.util.IoUtil;
import cfca.paperless.client.util.PaperlessUtil;
import cfca.paperless.client.util.StrategyUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

/**
 * @Description 2.5 Pdf自动化签章接口（测试用例）
 * @Author dell
 * @Date 2016-5-13
 * @CodeReviewer TODO
 */
public class testSealAutoPdf {

    public static void main(String[] args) throws Exception {
        try {
            long timeStart = new Date().getTime();// 开始时间
            
            PaperlessClient clientBean = new PaperlessClient(PaperlessConfig.url);// 无纸化基本接口的访问URL
            String keyStorePath = "E:\\testdata\\cfca\\localhost.jks";
            clientBean.initSSLContext(keyStorePath, "11111111", keyStorePath, "11111111");

            String filePath = "./TestData/file.pdf";
            byte[] pdfFileData = IoUtil.read(new FileInputStream(filePath));
            
            // 印章编码和印章密码，需要在无纸化管理系统中添加此印章的信息，登录管理页面->选择电子印章管理->选择印章管理->添加印章信息（需要先添加相应的印模信息和印章证书信息）
            String sealCode = "org001sm2";//0613sm201
            String sealPassword = "11111111";
            
            // 可以为空，不为空则此图片会替代此处印章的印模图片
            byte[] handwritingImage = IoUtil.read(new FileInputStream("./TestData/zhangfei.png"));

            SealUserInfo sealUserInfo = new SealUserInfo("张三", "beijing", "reason");
            sealUserInfo.setSealImageSize(100);
            // 3=关键字签章
            SignLocation signLocation = new SignLocation("人签名", "R", 0, 0);
            
            // 生成签章策略文件
            String sealStrategyXml = StrategyUtil.createSealStrategyXml(sealCode, sealPassword, "", sealUserInfo, signLocation);

            // 操作员编码或者机构号
            String operatorCode = PaperlessConfig.operatorCode;
            // 渠道编码，可以为空
            String channelCode = PaperlessConfig.channelCode;

            // 取得签章后的PDF文件数据
            byte[] sealedPdfData = clientBean.sealAutoPdf(pdfFileData, sealStrategyXml, operatorCode, channelCode);

            String errorRsString = PaperlessUtil.isError(sealedPdfData);

            // 处理结果为正常，保存签章后的PDF文件到本地目录下
            if ("".equals(errorRsString)) {
                System.out.println("OK:sealAutoPdf");
                System.out.println(sealedPdfData.length);
                IoUtil.write("./TestData/output/sealedPdf-" + new File(filePath).getName() + ".pdf", sealedPdfData);
            } else {
                // 处理结果为异常，打印出错误码和错误信息
                System.out.println("NG:sealAutoPdf");
                System.out.println(sealedPdfData.length);
                System.out.println(new String(sealedPdfData, "UTF-8"));
            }
            
            long timeEnd = new Date().getTime();// 结束时间
            System.out.println("time:" + (timeEnd - timeStart));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
