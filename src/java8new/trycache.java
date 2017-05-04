package java8new;

import java.io.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/1 0001 19:42
 */
public class trycache {

    public static void main(String[] args) {


        try(
                FileOutputStream fos = new FileOutputStream("E:\\testdata\\test001.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                FileInputStream fis = new FileInputStream("E:\\testdata\\who.txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bf = new BufferedReader(isr);

                ){

            bw.write("ni hao sm gui!");
            bw.flush();

            String hastext = null;
            while ((hastext = bf.readLine())!=null){
                System.out.println(hastext);

            }

        }catch (Exception e){

            System.out.println(e.getMessage());

        }
    }
}




