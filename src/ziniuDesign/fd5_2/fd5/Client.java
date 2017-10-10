package ziniuDesign.fd5_2.fd5;


import ziniuDesign.fd5_2.fd5.uuid3.Uuid3Factory;

public class Client {
	public static void main(String[] args) {

		for(int i=0;i<21;i++){
			String uuid =  Uuid3Factory.createIUuid().genUuid("Doc"
					,true,"字第 # 号","0",30,false,null,5
			);
			System.out.println("doc uuid1==="+uuid);
		}
	}
}
