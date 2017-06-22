package javaNIO.nio;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/7 0007 21:55
 */
public class NIOUtil {

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://ziniuxiaozhu.com");
        ReadableByteChannel src = Channels.newChannel(url.openStream());
        FileChannel dest = new FileOutputStream("E:\\testdata\\index.html").getChannel();

        NIOUtil.dump(src,dest);
    }

    private static void dump(ReadableByteChannel src, FileChannel dest) throws Exception{

        ByteBuffer allocate = ByteBuffer.allocate(1024);
        try(ReadableByteChannel srcCH = src;
            WritableByteChannel destCH = dest
            ){

            while (srcCH.read(allocate)!=-1){

                allocate.flip();
                destCH.write(allocate);
                allocate.clear();
            }
        }
    }
}
