package ziniuDesign.fd5_2.fd4.uuid2;

public class Uuid2Factory {
	private Uuid2Factory(){}
	
	public static IUuid createIUuid(){
		return new Uuid3Adapter();
	}
}
