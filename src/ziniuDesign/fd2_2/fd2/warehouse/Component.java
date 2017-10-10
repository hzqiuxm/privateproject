package ziniuDesign.fd2_2.fd2.warehouse;

import java.util.Map;

public abstract class Component {

	private int id;
	private int pId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	public void addChild(Component c){
		throw new UnsupportedOperationException("对象不支持此功能");
	}
	public void removeChild(Component c){
		throw new UnsupportedOperationException("对象不支持此功能");
	}
	public Component getChildren(int index){
		throw new UnsupportedOperationException("对象不支持此功能");
	}
	public Map<Integer,Integer> allUseGrids(Map<Integer,Integer> map){
		throw new UnsupportedOperationException("对象不支持此功能");
	}
	
	public abstract Object accept(Visitor v);
}
