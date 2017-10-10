package ziniuDesign.fd4_2.uuid2.arithmatic;

import java.util.Date;

public class TimeStampArithmatic implements IArithmatic{

	@Override
	public String genUuid(String businessType) {
		return businessType + new Date().getTime();
	}

}
