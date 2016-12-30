package javaNIO.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/30 0030 10:59
 */
public class NIOServer {

    private int flag = 1;
    private int blockSize = 4096;
    private int port = 7080;
    private ByteBuffer sendBuffer = ByteBuffer.allocate(blockSize);
    private ByteBuffer receiveBuffer = ByteBuffer.allocate(blockSize);
    private Selector selector;

    public NIOServer() {

        try {

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();//打开一个服务端渠道
            serverSocketChannel.configureBlocking(false);//设置非阻塞
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress(port));//绑定IP端口

            selector = Selector.open();//打开选择器
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//注册
            System.out.println("Server start : "+ port);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //监听
    public void listen() throws IOException{
        while (true){
            System.out.println("开始监听.....");
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            System.out.println("1111");
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();

                //业务逻辑
                handleKey(selectionKey);
            }

        }
    }

    //业务逻辑处理
    public void handleKey(SelectionKey selectionKey) throws IOException{

        ServerSocketChannel server = null;//服务器端
        SocketChannel client = null;//客户端

        String receiveText;
        String sendText;
        int count = 0;

        if(selectionKey.isAcceptable()){
            server = (ServerSocketChannel) selectionKey.channel();
            client = server.accept();
            client.configureBlocking(false);
            client.register(selector,SelectionKey.OP_READ);

        }else if(selectionKey.isReadable()){
            client = (SocketChannel) selectionKey.channel();
            count = client.read(receiveBuffer);

            if(count>0){
                receiveText = new String(receiveBuffer.array(),0,count);
                System.out.println("服务端接收到的信息: " + receiveText);

                client.register(selector,SelectionKey.OP_WRITE);
            }
        }else if(selectionKey.isWritable()){

            sendBuffer.clear();
            client = (SocketChannel) selectionKey.channel();

            sendText = "服务端写到：我是服务端的消息!" + flag++;
            sendBuffer.put(sendText.getBytes());
            sendBuffer.flip();
            client.write(sendBuffer);
            System.out.println("我已经发送给客户端了...");

        }
    }

    public static void main(String[] args) throws IOException {

        NIOServer nioServer = new NIOServer();
        nioServer.listen();
    }
}
