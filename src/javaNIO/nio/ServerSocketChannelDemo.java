package javaNIO.nio;

import java8new.Person;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/1/4 0004 20:55
 */
public class ServerSocketChannelDemo {

    public static void startServer() throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8999));
        serverSocketChannel.configureBlocking(false);//非阻塞
        System.out.println("服务端开始运行>>>>>>>>>>");

        while (true) {


            SocketChannel socketChannel = serverSocketChannel.accept();//等待一个客户端channel

            if (socketChannel != null) {

                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int size = socketChannel.read(byteBuffer);
                System.out.println(size );

                while (size > 0) {
                    byteBuffer.flip();
                    Charset charset = Charset.forName("UTF-8");
                    System.out.println(charset.newDecoder().decode(byteBuffer));
                    size = socketChannel.read(byteBuffer);

                }
                byteBuffer.clear();

                ByteBuffer respose = ByteBuffer.wrap("hello 我已经收到你的请求了".getBytes("UTF-8"));
                socketChannel.write(respose);
                respose.clear();
//                socketChannel.close();
            }


        }

    }

    public static void main(String[] args) throws Exception{

       startServer();
    }
}
