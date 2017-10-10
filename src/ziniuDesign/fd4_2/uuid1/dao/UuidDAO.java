package ziniuDesign.fd4_2.uuid1.dao;


import ziniuDesign.fd4_2.uuid1.UuidVO;

public interface UuidDAO {
	public UuidVO getByBusinessType(String businessType);
	public void updateUuid(UuidVO uuidVo);
	public void createUuid(UuidVO uuidVo);
}
