package javaNIO.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/1/4 0004 20:41
 */
public class NioDemo {

    public static void main(String[] args) {
        try {
            Charset charset = Charset.forName("GBK");//Java.nio.charset.Charset处理了字符转换问题。它通过构造CharsetEncoder和CharsetDecoder将字符序列转换成字节和逆转换。
            CharsetDecoder decoder = charset.newDecoder();

            RandomAccessFile raf = new RandomAccessFile("E:\\testdata\\data.txt", "rw");
            FileChannel fc = raf.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(10);
            CharBuffer cb = CharBuffer.allocate(10);

            int count = fc.read(buffer);
            while (count != -1) {
                System.out.println("count = "+count);
                buffer.flip();
                decoder.decode(buffer, cb, false);
                cb.flip();
                while (cb.hasRemaining()) {
                    System.out.print(cb.get());
                }
                System.out.println();
                buffer.clear();
                cb.clear();
                count = fc.read(buffer);
            }
            raf.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
