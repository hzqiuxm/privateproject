package ziniuDesign.fd5_1.fd5.uuid3.dao;


import ziniuDesign.fd5_1.fd5.uuid3.UuidVO;

public interface UuidDAO {
	public UuidVO getByBusinessType(String businessType);
	public void updateUuid(UuidVO uuidVo);
	public void createUuid(UuidVO uuidVo);
}
