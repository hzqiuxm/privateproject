package javaNIO.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/30 0030 13:57
 */
public class AIOServer {


    public AIOServer(int port) throws IOException {
        AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(port));

        listener.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                    listener.accept(null,this);
                try {
                    handler(result);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("AIO 失败!");
            }
        });
    }

    //业务逻辑
    public void handler(AsynchronousSocketChannel ch) throws ExecutionException, InterruptedException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        ch.read(byteBuffer).get();
        byteBuffer.flip();
        System.out.println("服务端接收AIO: " + byteBuffer.get());

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        int port = 7081;
        AIOServer aioServer = new AIOServer(port);
        System.out.println("监听开始： " + port);
        Thread.sleep(100000000);

    }
}
