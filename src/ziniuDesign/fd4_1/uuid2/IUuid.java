package ziniuDesign.fd4_1.uuid2;

import ziniuDesign.fd4_1.uuid2.arithmatic.IArithmatic;

public interface IUuid {
	public String genUuid(String businessType,
                          boolean needFormat, String formatStr, String c, int len,
                          boolean needArithmatic, IArithmatic ia);
	
	//字第001 号
	//20
}
