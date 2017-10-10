package ziniuDesign.fd5_2.fd4.uuid1;

import ziniuDesign.fd5_2.fd5.uuid3.Uuid3Factory;

public class Uuid3Adapter implements IUuid{

	@Override
	public int genUuid(String businessType) {

		String uuid = Uuid3Factory.createIUuid().genUuid(businessType,
				false, "","", 0, 
				false, null,10);
		
		return Integer.parseInt(uuid);
	}
}
