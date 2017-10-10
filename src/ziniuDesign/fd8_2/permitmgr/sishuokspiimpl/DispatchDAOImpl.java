package ziniuDesign.fd8_2.permitmgr.sishuokspiimpl;

import ziniuDesign.fd8_2.permitmgr.sishuokspiimpl.db.MapDB;
import ziniuDesign.fd8_2.permitmgr.spi.dispatch.DispatchDAO;

import java.util.ArrayList;
import java.util.List;


public abstract class DispatchDAOImpl<M> implements DispatchDAO<M> {

	@Override
	public void create(M m) {
		String key = m.getClass().getName();
		List<M> list = new ArrayList<M>();
		Object obj = MapDB.getMapDB().get(key);
		if(obj!=null){
			list = (List<M>)obj;
		}		
		list.add(m);
		MapDB.getMapDB().put(key, list);
	}

	@Override
	public void update(M m) {		
		String key = m.getClass().getName();
		List<M> list = new ArrayList<M>();
		Object obj = MapDB.getMapDB().get(key);
		if(obj!=null){
			list = (List<M>)obj;
		}
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(m)){
				list.set(i,m);
				break;
			}
		}
		MapDB.getMapDB().put(key, list);
	}

	@Override
	public void delete(M m) {
		String key = m.getClass().getName();
		List<M> list = new ArrayList<M>();
		Object obj = MapDB.getMapDB().get(key);
		if(obj!=null){
			list = (List<M>)obj;
		}
		
		list.remove(m);

		MapDB.getMapDB().put(key, list);
	}

	@Override
	public M getById(int id) {
//		String key = m.getClass().getName();
//		List<M> list = new ArrayList<M>();
//		Object obj = MapDB.getMapDB().get(key);
//		if(obj!=null){
//			list = (List<M>)obj;
//		}
//		
//		for(int i=0;i<list.size();i++){
//			if(list.get(i).toString().contains("id="+id+",")){
//				return list.get(i);
//			}
//		}
		return null;
	}

	@Override
	public List<M> getByCondition(M m, int begin, int pageSize) {
		List<M> retList = new ArrayList<M>();
		
		String key = m.getClass().getName();
		List<M> list = new ArrayList<M>();
		Object obj = MapDB.getMapDB().get(key);
		if(obj!=null){
			list = (List<M>)obj;
		}
		
		for(int i=0;i<list.size();i++){
			if(this.judgeCondition(m, list.get(i))){
				retList.add(list.get(i));
			}
		}
		return retList;
	}
	protected abstract boolean judgeCondition(M m, M model);
}