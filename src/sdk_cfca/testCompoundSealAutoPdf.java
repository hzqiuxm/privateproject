package sdk_cfca;

import cfca.paperless.client.bean.*;
import cfca.paperless.client.servlet.PaperlessClient;
import cfca.paperless.client.util.Base64;
import cfca.paperless.client.util.IoUtil;
import cfca.paperless.client.util.PaperlessUtil;
import cfca.paperless.client.util.StrategyUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testCompoundSealAutoPdf {

    public static void main(String[] args) throws Exception {

        try {
            PaperlessClient clientBean = new PaperlessClient(PaperlessConfig.url);
            
///////////////////////////如下为用户1手写签名相关的数据，如果没用用户1此处可以省略/////////////////////////////////////////////////
            byte[] handwritingImage1 = IoUtil.read(new FileInputStream("./TestData/handwriting.png"));
            byte[] handwritingData1 = handwritingImage1;
            byte[] identificationFrontData = IoUtil.read(new FileInputStream("./TestData/1.png"));
            byte[] identificationBackData = IoUtil.read(new FileInputStream("./TestData/2.png"));
            List<MultiDataBean> list1 = new ArrayList<MultiDataBean>();
            list1.add(new MultiDataBean(handwritingData1, "handwritingData.dat", "media-id", "0"));//手写签名数据
            list1.add(new MultiDataBean(handwritingImage1, "handwritingImage.png", "2"));//手写签名图片
            list1.add(new MultiDataBean(identificationFrontData, "identificationFrontImage.png", "2"));//身份证正面
            list1.add(new MultiDataBean(identificationBackData, "identificationBackImage.png", "2"));//身份证反面
            String proofHashAndMultiData1[] = PaperlessUtil.getProofHashAndMultiData(list1);

            SignLocation signLocation = new SignLocation(1, "代理人签名", "R", 10, 0);
            SealUserInfo sealUserInfo = new SealUserInfo("张三a", "Z", "00000000000000000", "15744659823", "北京", "签合同");
            String proofSealStrategyXml1 = StrategyUtil.createProofSealStrategyXml(handwritingImage1, sealUserInfo, signLocation, proofHashAndMultiData1[0]);
            String sealLayer2Text = "苏才礼";
            String sealLayer2TextStyle = "font-size:12;";
//            proofSealStrategyXml1 = StrategyUtil.createProofSealStrategyXml(sealLayer2Text,sealLayer2TextStyle, sealUserInfo, signLocation, proofHashAndMultiData1[0]);
            System.out.println(111);
///////////////////////////以上为用户1的数据/////////////////////////////////////////////////

            ///////////////////////////如下为加盖机构印章的策略/////////////////////////////////////////////////
            signLocation = new SignLocation(1, "银行签章", "D", 20, 20);signLocation.setPage(1);
            sealUserInfo = new SealUserInfo("签章者", "北京", "签合同");sealUserInfo.setBusinessCode("0000000");
            String sealCode = "1001";
            String sealPassword = "11111111";
            String sealStrategyXml = StrategyUtil.createSealStrategyXml(sealCode, sealPassword, sealUserInfo, signLocation);
//            String sealLayer2Text = "张三";
//            String sealLayer2TextStyle = "font-size:12;";
//            String sealStrategyXml = StrategyUtil.createSealStrategyXml(sealCode, sealPassword, sealLayer2Text, sealLayer2TextStyle, sealUserInfo, signLocation)

            byte[] pdfFile = IoUtil.read(new FileInputStream("./TestData/file.pdf"));
            String compoundSealStrategyXml = "<List>" + "" + sealStrategyXml +  "</List>";
            //outputFilePath = "/clsu/pdf/pdf2/" + savedPdfId + ".pdf";
            String multiData = "[" + proofHashAndMultiData1[1] + "]";
            String bizTypeCode = "B001";//业务类型，比如：开户、开通网银
            PdfBean pdfBean = new PdfBean(Base64.toBase64String(pdfFile), bizTypeCode);
            pdfBean = new PdfBean(Base64.toBase64String(pdfFile), "a", bizTypeCode, "auto");
            //PdfBean pdfBean = new PdfBean(Base64.toBase64String(pdfFile), bizTypeCode);
            String pdfBeanXml = PaperlessUtil.buildPdfBeanXml(pdfBean);
            long start = new Date().getTime();
            String channelBeanXml = new ChannelBean(PaperlessConfig.channelCode).toString();
            byte[] sealedPdf = clientBean.compoundSealAutoPdf(pdfBeanXml, multiData, compoundSealStrategyXml, PaperlessConfig.operatorCode, channelBeanXml);

            System.out.println(sealedPdf.length);
            String errorRsString = PaperlessUtil.isError(sealedPdf);
            if ("".equals(errorRsString)) {
                IoUtil.write("./TestData/output/compoundSealAutoPdf.pdf", sealedPdf);
            } else {
                System.out.println(new String(sealedPdf, "UTF-8"));
            }
            System.out.println("########## compoundSealAutoPdf" + " end,time:" + (new Date().getTime() - start) + "##########");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
