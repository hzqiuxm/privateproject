package ziniuDesign.fd4_2.uuid1.dao;


import ziniuDesign.fd4_2.util.file.FileHelper;
import ziniuDesign.fd4_2.uuid1.UuidVO;


import java.util.HashMap;
import java.util.Map;

public class FileImpl implements UuidDAO{
	private static final String FILE_PATHNAME= "Uuid.txt"; 
	private Map<String,UuidVO> map =  null;
	
	private void initMap(){
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

}
