package ziniuDesign.fd4_2.uuid1;

public class Uuid1Factory {
	private Uuid1Factory(){}
	
	public static IUuid createIUuid(){
//		return new UuidService();
		
		return new Uuid2Adapter();
		
	}
}
