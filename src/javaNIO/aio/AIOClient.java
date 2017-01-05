package javaNIO.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/30 0030 13:57
 */
public class AIOClient {

    private AsynchronousSocketChannel client= null;

    public AIOClient(String host, int port) throws IOException, ExecutionException, InterruptedException {
        client = AsynchronousSocketChannel.open();
        Future<Void> future = client.connect(new InetSocketAddress(host, port));
        System.out.println("future" + future.get());


    }

    public void writedata(byte b) throws Exception{
//        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
//        byteBuffer.put(b);
        ByteBuffer byteBuffer = ByteBuffer.wrap("hello".getBytes("UTF-8"));
//        byteBuffer.flip();
        client.write(byteBuffer);
        byteBuffer.clear();
        client.close();

    }

    public static void main(String[] args) throws Exception{

        String host = "127.0.0.1";
        int port = 7081;
        AIOClient aioClient = new AIOClient(host,port);
        aioClient.writedata((byte) 11);

    }
}
