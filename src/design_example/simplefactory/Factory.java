package design_example.simplefactory;/**
 * Created by hzqiuxm on 2015/3/28.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by hzqiuxm on 2015/3/28.
 */
public class Factory {
    public static Api createApi(){
        Properties p = new Properties();
        InputStream ips = null;
        try {
//            System.out.println(Factory.class.getClass().getResource("/").getPath());
            ips = Factory.class.getResourceAsStream("/factory.properties");
            if(ips==null){
                System.err.println("ips是空的！");
            }
            p.load(ips);
        } catch (IOException e) {
            System.err.println("获取配置文件出错.......");
            e.printStackTrace();
        }


        Api api = null;
        try {
            api = (Api)Class.forName(p.getProperty("Implclass")).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  api;

    }
}
