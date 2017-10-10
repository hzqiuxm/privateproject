package ziniuDesign.fd4_2.uuid2.dao;


import ziniuDesign.fd4_2.uuid2.UuidVO;

public interface UuidDAO {
	public UuidVO getByBusinessType(String businessType);
	public void updateUuid(UuidVO uuidVo);
	public void createUuid(UuidVO uuidVo);
}
