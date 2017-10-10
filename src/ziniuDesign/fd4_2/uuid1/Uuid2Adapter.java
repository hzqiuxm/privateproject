package ziniuDesign.fd4_2.uuid1;


import ziniuDesign.fd4_2.uuid2.Uuid2Factory;

public class Uuid2Adapter implements IUuid{

	@Override
	public int genUuid(String businessType) {

		String uuid = Uuid2Factory.createIUuid().genUuid(businessType,
				false, "","", 0, 
				false, null);
		
		return Integer.parseInt(uuid);
	}
}
