package javaNIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/29 0029 20:00
 */
public class BUfferTest2 {

    public static void main(String[] args) throws Exception{


        ByteBuffer byteBuffer = ByteBuffer.allocate(10);//中文乱码问题如何解决呢？
        RandomAccessFile raf = null;
        FileChannel channel = null;

        try {

            raf = new RandomAccessFile("E:\\testdata\\data3","rw");
            channel = raf.getChannel();

            int size = channel.read(byteBuffer);

            while (size>0) {

                //切换到写模式
                byteBuffer.flip();

//                while (byteBuffer.hasRemaining()){
//                    System.out.println(byteBuffer.getChar());
//                }

                Charset charset = Charset.forName("UTF-8");
                System.out.println("bytebuffer = " + charset.decode(byteBuffer).toString());
                byteBuffer.clear();
                size = channel.read(byteBuffer);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            channel.close();
            raf.close();

        }



    }
}
