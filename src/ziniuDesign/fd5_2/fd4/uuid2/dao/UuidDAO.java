package ziniuDesign.fd5_2.fd4.uuid2.dao;

import ziniuDesign.fd5_2.fd4.uuid1.UuidVO;

public interface UuidDAO {
	public UuidVO getByBusinessType(String businessType);
	public void updateUuid(UuidVO uuidVo);
	public void createUuid(UuidVO uuidVo);
}
