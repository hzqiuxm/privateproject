package ziniuDesign.fd6_2.mes.messagetrans.server;

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
				System.out.println("now MesServer msg===="+obj);

				//返回数据
				String msg = "MesServer back=="+obj;
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
