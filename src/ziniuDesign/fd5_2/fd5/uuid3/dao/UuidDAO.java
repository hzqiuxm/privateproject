package ziniuDesign.fd5_2.fd5.uuid3.dao;

import ziniuDesign.fd5_2.fd5.uuid3.UuidVO;

import java.util.Map;


public interface UuidDAO {
	public UuidVO getByBusinessType(String businessType);
	public void updateUuid(UuidVO uuidVo);
	public void createUuid(UuidVO uuidVo);
	
	public Map<String,Integer> getAll();
}
