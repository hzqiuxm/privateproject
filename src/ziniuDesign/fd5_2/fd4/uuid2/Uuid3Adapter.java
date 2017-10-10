package ziniuDesign.fd5_2.fd4.uuid2;


import ziniuDesign.fd5_2.fd4.uuid2.arithmatic.IArithmatic;
import ziniuDesign.fd5_2.fd5.uuid3.Uuid3Factory;

public class Uuid3Adapter implements IUuid{

	@Override
	public String genUuid(String businessType, boolean needFormat,
			String formatStr, String c, int len, boolean needArithmatic,
			IArithmatic ia) {
		return Uuid3Factory.createIUuid()
				.genUuid(businessType, needFormat, formatStr, c, len, false, null, 10);
		 
	}
}
