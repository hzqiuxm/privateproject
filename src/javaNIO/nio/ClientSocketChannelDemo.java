package javaNIO.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/1/4 0004 21:02
 */
public class ClientSocketChannelDemo {

    public static void startClient() throws Exception{

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8999));
        socketChannel.configureBlocking(false);//客户端读不到的情况下，改成阻塞就能读到了

        String request = "hello ServerSocketChannel";
        ByteBuffer byteBuffer = ByteBuffer.wrap(request.getBytes("UTF-8"));
        socketChannel.write(byteBuffer);

        ByteBuffer rbuf = ByteBuffer.allocate(64);
        int size = socketChannel.read(rbuf);

        while(size>0){
            rbuf.flip();
            Charset charset = Charset.forName("UTF-8");
            System.out.println(charset.newDecoder().decode(rbuf));
            rbuf.clear();
            size = socketChannel.read(rbuf);

        }

        byteBuffer.clear();
        rbuf.clear();
        socketChannel.close();
        Thread.sleep(50000);


    }

    public static void main(String[] args)  throws Exception{

        startClient();

    }
}
