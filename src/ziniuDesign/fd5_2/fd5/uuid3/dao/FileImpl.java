package ziniuDesign.fd5_2.fd5.uuid3.dao;

import ziniuDesign.fd5_2.fd5.uuid3.UuidVO;
import ziniuDesign.fd5_2.util.file.FileHelper;

import java.util.HashMap;
import java.util.Map;


public class FileImpl implements UuidDAO{
	private static final String FILE_PATHNAME= "Uuid.txt"; 
	private Map<String,UuidVO> map =  null;
	
	private void initMap(){
		System.out.println("now initMap===================");
		if(map == null){
			map = (Map<String,UuidVO>) FileHelper.readFile(FILE_PATHNAME);
			if(map==null){
				map = new HashMap<String,UuidVO>();
			}
		}
	}
	
	@Override
	public UuidVO getByBusinessType(String businessType) {
		initMap();
		
		return map.get(businessType);
	}

	@Override
	public void updateUuid(UuidVO uuidVo) {
		initMap();
		map.put(uuidVo.getBusinessType(), uuidVo);
		//写文件
		FileHelper.writeFile(FILE_PATHNAME, map);
	}

	@Override
	public void createUuid(UuidVO uuidVo) {
		this.updateUuid(uuidVo);
	}

	@Override
	public Map<String, Integer> getAll() {
		initMap();
		Map<String,Integer> retMap = new HashMap<String,Integer>();
		
		for(String key : map.keySet()){
			retMap.put(key, map.get(key).getUuid());
		}
		return retMap;
	}

}
