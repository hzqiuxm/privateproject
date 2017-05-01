package sdk_cfca.asist;

import cfca.paperless.client.servlet.PaperlessClient;
import cfca.paperless.client.util.GUID;
import cfca.paperless.client.util.IoUtil;
import cfca.paperless.client.util.PaperlessUtil;
import sdk_cfca.PaperlessConfig;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Description 3.1 Html/Word转换Pdf功能（测试用例）
 * @Author dell
 * @Date 2016-5-13
 * @CodeReviewer TODO
 */
public class testTransformToPdf {

    public static void main(String[] args) throws Exception {
        try {
            PaperlessClient clientBean = new PaperlessClient(PaperlessConfig.assistUrl);// 无纸化辅助接口的访问URL
            //双向ssl
//          clientBean.initSSLContext(PaperlessConfig.keyStorePath, PaperlessConfig.keyStorePassword, PaperlessConfig.trustStorePath, PaperlessConfig.trustStorePassword);

            // 文件类型，可以取值：“html” “html2” “word2”
            String fileType = "html";
            // 待转换成PDF文件的HTML文件，
            String filePath = "E:\\testdata\\cfca\\file.html";
            byte[] fileData = IoUtil.read(new FileInputStream(filePath));

            // 不为空，则用于在数据库中临时PDF文件表保存用，[TEMP_FILE_PDF]-[PDF_ID]
            // 为空，则不会在数据库中临时PDF文件表保存数据
            String savedPdfId = GUID.generateId();

            // 操作员编码或者机构号
            String operatorCode = PaperlessConfig.operatorCode;
            // 渠道编码，可以为空
            String channelCode = PaperlessConfig.channelCode;

            // 取得转换后的PDF文件数据
            byte[] result = clientBean.transformToPdf(fileData, fileType, savedPdfId, operatorCode, channelCode);

            String errorRsString = PaperlessUtil.isError(result);

            // 处理结果为正常，保存转换后的PDF文件到本地目录下
            if ("".equals(errorRsString)) {
                System.out.println("OK:transformToPdf");
                System.out.println(result.length);
                IoUtil.write("E:\\testdata\\cfca\\htmlToPdf-" + new File(filePath).getName() + ".pdf", result);
            } else {
                System.out.println("NG:transformToPdf");
                System.out.println(result.length);
                // 处理结果为异常，打印出错误码和错误信息
                System.out.println(new String(result, "UTF-8"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
