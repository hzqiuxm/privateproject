package ziniuDesign.fd7_1.fd6.mes.business.vo;

import java.util.ArrayList;
import java.util.List;

public class MsgVO {
	private String msgType = "";
	private String l2Id = "";
	private List<String> pids = new ArrayList<String>();
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getL2Id() {
		return l2Id;
	}
	public void setL2Id(String l2Id) {
		this.l2Id = l2Id;
	}
	public List<String> getPids() {
		return pids;
	}
	public void setPids(List<String> pids) {
		this.pids = pids;
	}

	
}
