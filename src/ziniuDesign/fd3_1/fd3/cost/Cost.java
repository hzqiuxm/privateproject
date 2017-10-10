package ziniuDesign.fd3_1.fd3.cost;

import ziniuDesign.fd3_1.db.MapDB;

import java.util.List;


public class Cost implements ICost{

	@Override
	public GroupModel calcCost(int groupId, List<String> calcItems) {
		
		GroupModel gm = (GroupModel) MapDB.getMapDB().get(groupId);

		//业务计算
		//kkkkk
		
		gm.calcCost(calcItems);
		
		return gm;
	}
}
