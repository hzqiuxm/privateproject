package ziniuDesign.fd4_2.uuid2;

public class Uuid2Factory {
	private Uuid2Factory(){}
	
	public static IUuid createIUuid(){
		return new UuidService();
	}
}
