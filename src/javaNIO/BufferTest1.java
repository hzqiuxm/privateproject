package javaNIO;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/29 0029 16:05
 */
public class BufferTest1 {
    public static void main(String[] args) {

//        CharBuffer charBuffer = CharBuffer.allocate(100);
//        System.out.println(charBuffer.compact());
//        System.out.println(charBuffer.length());
//        System.out.println(charBuffer.position());

        try {

            RandomAccessFile raf = new RandomAccessFile("E:\\testdata\\number.txt","rw");
            FileChannel fileChannel = raf.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int bytesRead = fileChannel.read(byteBuffer);

            System.out.println("第一次写完后读之前position:" + byteBuffer.position());
            System.out.println("第一次写完后读之前limit:" + byteBuffer.limit());
            System.out.println("第一次写完后读之前capacity:" + byteBuffer.capacity());

            while (bytesRead != -1){
                //Make buffer ready to read
                byteBuffer.flip();

                System.out.println("切换到读buffer的position:" + byteBuffer.position());
                System.out.println("切换到读buffer的limit:" + byteBuffer.limit());
                System.out.println("切换到读buffer的capacity:" + byteBuffer.capacity());


                while(byteBuffer.hasRemaining()){
                    System.out.println((char) byteBuffer.get());
                }

                //Make buffer ready for writing
                byteBuffer.clear();
                bytesRead = fileChannel.read(byteBuffer);
                System.out.println("写完后buffer的position:" + byteBuffer.position());
                System.out.println("写完后buffer的limit:" + byteBuffer.limit());
                System.out.println("写完后buffer的capacity:" + byteBuffer.capacity());
            }

            raf.close();



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
