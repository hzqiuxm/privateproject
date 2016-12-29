package javaNIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/29 0029 20:00
 */
public class BUfferTest2 {

    public static void main(String[] args) {

        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = { header, body };

        RandomAccessFile raf = null;
        try {

            raf = new RandomAccessFile("E:\\testdata\\number.txt","rw");
            FileChannel channel = raf.getChannel();
            channel.read(bufferArray);//写满第一个再写第二个


//            //选择器使用
//            Selector selector = Selector.open();
//            channel.configureBlocking(false);
//            SelectionKey key = channel.register(selector,Selectionkey.OP_READ);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
