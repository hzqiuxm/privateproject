package javaNIO.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/30 0030 12:07
 */
public class NIOClient {

    private static int flag = 1;
    private static int blockSize = 4096;
    private static ByteBuffer sendBuffer = ByteBuffer.allocate(blockSize);
    private static ByteBuffer receiveBuffer = ByteBuffer.allocate(blockSize);
    private final static InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1",7080);


    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);



        //打开选择器注册连接
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(serverAddress);

        //
        Set<SelectionKey> selectionKeys;
        Iterator<SelectionKey> iterator;
        SelectionKey selectionKey;
        SocketChannel client;
        String receiveText;
        String sendText;
        int count;


        while (true){

           selectionKeys =  selector.selectedKeys();
            iterator = selectionKeys.iterator();


           while (iterator.hasNext()){
               System.out.println("55555555555555555");
               selectionKey = iterator.next();

               if(selectionKey.isConnectable()) {
                   System.out.println("客户端连接操作....");
                   client = (SocketChannel) selectionKey.channel();
                   if (client.isConnectionPending()) {
                       client.finishConnect();
                       System.out.println("=======客户端已连接到服务器!=======");
                       sendBuffer.clear();
                       sendBuffer.put("hello server ".getBytes());
                       sendBuffer.flip();
                       client.write(sendBuffer);
                   }
                   client.register(selector, SelectionKey.OP_READ);
               }else if(selectionKey.isReadable()){
                    client = (SocketChannel) selectionKey.channel();
                    receiveBuffer.clear();
                    count = client.read(receiveBuffer);
                    if(count>0){
                        receiveText = new String(receiveBuffer.array(),0,count);
                        System.out.println("客户端接收到服务器的数据是： " + receiveText);
                        client.register(selector,SelectionKey.OP_WRITE);
                    }

               }else if(selectionKey.isWritable()){
                   sendBuffer.clear();
                   client = (SocketChannel) selectionKey.channel();
                   sendText = "注册完写事件后发送消息给服务器" +flag++;
                   sendBuffer.put(sendText.getBytes());
                   sendBuffer.flip();
                   client.write(sendBuffer);
                   System.out.println("=====发送消息给服务器完毕!=====");
                   client.register(selector,SelectionKey.OP_READ);
               }
           }
           selectionKeys.clear();
        }




    }
}
