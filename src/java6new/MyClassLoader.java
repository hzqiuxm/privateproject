package java6new;

import java.io.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/24 0024 14:00
 */
public class MyClassLoader extends ClassLoader{

    private String classpath = "";

    public MyClassLoader() {
    }

    public MyClassLoader(String classpath) {
        this.classpath = classpath;
    }

    private static void cypher(InputStream ips, OutputStream ops) throws Exception{

        int b = -1;
        while ((b = ips.read())!=-1){
            ops.write(b^ 0xff);
        }
    }

    //自己的类加载器加载类并解密
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String finalName = classpath + "\\" + name + ".class";
        System.out.println("finalName = " + finalName);
        try {
            FileInputStream fis = new FileInputStream(finalName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            cypher(fis,bos);
            fis.close();
            byte[] bytes = bos.toByteArray();
            return defineClass(null,bytes,0,bytes.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws Exception{
        String srcPath = "D:\\Dev\\project\\privateproject\\out\\production\\privateproject\\java6new\\ClassLoaderAttr.class";
        String destpath = "D:\\Dev\\project\\privateproject\\lib\\ClassLoaderAttr.class";

        FileInputStream fis = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(destpath);
        cypher(fis,fos);
        fis.close();
        fos.close();

    }

}
