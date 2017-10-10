package ziniuDesign.fd7_2.fd6.mes.messagetrans.server;

import ziniuDesign.fd7_2.fd6.mes.business.state.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MesServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1111);
			
			while(true){
				Socket s = ss.accept();
				
				ObjectInputStream in = new ObjectInputStream(
						new BufferedInputStream(s.getInputStream())
				);
				Object obj = in.readObject();
				
				
				//后续业务操作

				//接到消息==〉处理消息流程
				//消息解析===消息进行处理（不同消息，处理方式不一样）===准备返回的电文=== 检测心跳电文 ===发送返回的电文

				System.out.println("now MesServer msg===="+obj);

				//返回数据
				String msg = new Context().request(""+obj);  //"MesServer back=="+obj;
				
				
				ObjectOutputStream out = new ObjectOutputStream(
						new BufferedOutputStream(s.getOutputStream())
				);
				out.writeObject(msg);
				
				out.close();
				in.close();
				s.close();						
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
