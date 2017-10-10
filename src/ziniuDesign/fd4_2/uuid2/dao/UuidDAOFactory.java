package ziniuDesign.fd4_2.uuid2.dao;

public class UuidDAOFactory {
	private UuidDAOFactory(){}
	
	public static UuidDAO createUuidDAO(){
		return new FileImpl();
	}
}
