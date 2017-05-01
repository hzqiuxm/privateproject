package sdk_cfca.asist;

import cfca.paperless.client.servlet.PaperlessClient;
import cfca.paperless.client.util.IoUtil;
import cfca.paperless.client.util.PaperlessUtil;
import cfca.paperless.client.util.StringUtil;
import sdk_cfca.PaperlessConfig;

/**
 * @Description 3.9 自助生成图片接口（测试用例）
 * @Author dell
 * @Date 2016-5-16
 * @CodeReviewer TODO
 */
public class testAutoGenerateImage {

    public static void main(String[] args) throws Exception {
        try {
            PaperlessClient clientBean = new PaperlessClient(PaperlessConfig.assistUrl);// 无纸化辅助接口的访问URL
//            clientBean.initSSLContext(PaperlessConfig.keyStorePath, PaperlessConfig.keyStorePassword, PaperlessConfig.trustStorePath, PaperlessConfig.trustStorePassword);
            
            // 操作员编码或者机构号
            String operatorCode = PaperlessConfig.operatorCode;
            // 渠道编码，可以为空
            String channelCode = PaperlessConfig.channelCode;

            String businessCode = "ABC123456789";
            String businessCodeStyle = "font-size:10;x-ratio:0.2;y-ratio:0.6";
            String name = "菡萏如佳人";
            String name2 = "云合同专用章";
            int width = 600;
            int height = 300;
            // 1：方型
            //  11：方形（带框）
            //  2：长方形（不带“章”字）
            //  21：长方形（带框）
            //  3：圆形（不带五角星）
            //  4：圆形（带五角星）
            int shape = 4;
            String color = "FF0000";
            int fontSize = 30;
            String imageStrategyXml = createImageStrategyXml(name, name2, width, height, shape, color, fontSize, businessCode, businessCodeStyle);
            String sealImageCode = "201610221711236065589981293696";
//            imageStrategyXml = createImageStrategyXml("", businessCode, businessCodeStyle);
            // 取得生成的图片文件数据
            byte[] result = clientBean.autoGenerateImage(imageStrategyXml, operatorCode, channelCode);

            String errorRsString = PaperlessUtil.isError(result);

            // 处理结果为正常，保存生成的图片文件到本地目录下
            if ("".equals(errorRsString)) {
                System.out.println("OK:autoGenerateImage");
                System.out.println(result.length);
                IoUtil.write("E:\\testdata\\cfca\\qxm.png", result);
            } else {
                // 处理结果为异常，打印出错误码和错误信息
                System.out.println("NG:autoGenerateImage");
                System.out.println(result.length);
                System.out.println(errorRsString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成图片生成策略文件
     * 
     * @return
     */
    public static String createImageStrategyXml(String name, String name2, int width, int height, int shape, String color, int fontSize, String businessCode, String businessCodeStyle) {

        StringBuilder imageStrategyXML = new StringBuilder();

        imageStrategyXML.append("<Request>");
        imageStrategyXML.append("<ImageName>").append(name).append("</ImageName>");// 长方形换行字符“##”
        imageStrategyXML.append("<ImageName2>").append(name2).append("</ImageName2>");// 
        imageStrategyXML.append("<ImageWidth>").append(width).append("</ImageWidth>");// 图片宽
        imageStrategyXML.append("<ImageHeight>").append(height).append("</ImageHeight>");// 图片高
        imageStrategyXML.append("<ImageShape>").append(shape).append("</ImageShape>");// 1：方型
                                                                                    //  11：方形（带框）
                                                                                    //  2：长方形（不带“章”字）
                                                                                    //  21：长方形（带框）
                                                                                    //  3：圆形（不带五角星）
                                                                                    //  4：圆形（带五角星）
        imageStrategyXML.append("<Color>").append(color).append("</Color>");     // 十六进制，默认FF0000
        imageStrategyXML.append("<FontSize>").append(fontSize).append("</FontSize>");  // 字体大小，默认100
        imageStrategyXML.append("<FontSize>").append(fontSize).append("</FontSize>");
        if(StringUtil.isNotEmpty(businessCode)) {
            imageStrategyXML.append("<BusinessCode>").append(businessCode).append("</BusinessCode>");
            imageStrategyXML.append("<BusinessCodeStyle>").append(businessCodeStyle).append("</BusinessCodeStyle>");
        }
        imageStrategyXML.append("</Request>");

        return imageStrategyXML.toString();
    }
    
    public static String createImageStrategyXml(String sealImageCode, String businessCode, String businessCodeStyle) {
        
        StringBuilder imageStrategyXML = new StringBuilder();
        imageStrategyXML.append("<Request>");
        imageStrategyXML.append("<SealImageCode>").append(sealImageCode).append("</SealImageCode>");
        if(StringUtil.isNotEmpty(businessCode)) {
            imageStrategyXML.append("<BusinessCode>").append(businessCode).append("</BusinessCode>");
            imageStrategyXML.append("<BusinessCodeStyle>").append(businessCodeStyle).append("</BusinessCodeStyle>");
        }
        imageStrategyXML.append("</Request>");

        return imageStrategyXML.toString();
    }

}
