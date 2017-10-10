package ziniuDesign.fd4_2;


import ziniuDesign.fd4_2.uuid1.Uuid1Factory;

public class Client {
	public static void main(String[] args) {
		int uuid =  Uuid1Factory.createIUuid().genUuid("Doc");
		System.out.println("doc uuid1==="+uuid);
		uuid =  Uuid1Factory.createIUuid().genUuid("Doc");
		System.out.println("doc uuid2==="+uuid);
		uuid =  Uuid1Factory.createIUuid().genUuid("File");
		System.out.println("File uuid==="+uuid);

//		IArithmatic ia = new TimeStampArithmatic();
//		
//		String uuid =  Uuid2Factory.createIUuid().genUuid("Doc"
//				,true,"字第 # 号","0",30,true,ia
//				);
//		System.out.println("doc uuid1==="+uuid);
//		uuid =  Uuid2Factory.createIUuid().genUuid("Doc"
//				,false,"字第 # 号","0",30,false,null
//				);
//		System.out.println("doc uuid2==="+uuid);
//		uuid =  Uuid2Factory.createIUuid().genUuid("Doc"
//				,false,"字第 # 号","0",30,true,ia
//				);
//		System.out.println("doc uuid3==="+uuid);
	}
}
