package ziniuDesign.fd5_2.fd4;

import ziniuDesign.fd5_2.fd4.uuid2.Uuid2Factory;
import ziniuDesign.fd5_2.fd4.uuid2.arithmatic.IArithmatic;
import ziniuDesign.fd5_2.fd4.uuid2.arithmatic.TimeStampArithmatic;

public class Client {
	public static void main(String[] args) {
		for(int i=0;i<11;i++){
//			int uuid =  Uuid1Factory.createIUuid().genUuid("Doc");
//			System.out.println("doc uuid1==="+uuid);
//			uuid =  Uuid1Factory.createIUuid().genUuid("Doc");
//			System.out.println("doc uuid2==="+uuid);
//			uuid =  Uuid1Factory.createIUuid().genUuid("File");
//			System.out.println("File uuid==="+uuid);
//		}

			IArithmatic ia = new TimeStampArithmatic();

			String uuid =  Uuid2Factory.createIUuid().genUuid("Doc"
					,true,"字第 # 号","0",30,true,null
			);
			System.out.println("doc uuid1==="+uuid);
			uuid =  Uuid2Factory.createIUuid().genUuid("Doc"
					,false,"字第 # 号","0",30,false,null
			);
			System.out.println("doc uuid2==="+uuid);
			uuid =  Uuid2Factory.createIUuid().genUuid("Doc"
					,false,"字第 # 号","0",30,true,null
			);
			System.out.println("doc uuid3==="+uuid);
		}
	}
}
