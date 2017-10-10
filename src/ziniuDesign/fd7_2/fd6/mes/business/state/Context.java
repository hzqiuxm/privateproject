package ziniuDesign.fd7_2.fd6.mes.business.state;


import ziniuDesign.fd7_2.fd6.mes.business.vo.MsgVO;

public class Context {
	private String msg = "";
	private String retMsg = "";
	private MsgVO msgVO = new MsgVO();
	
	MsgVO getMsgVO() {
		return msgVO;
	}
	void setMsgVO(MsgVO msgVO) {
		this.msgVO = msgVO;
	}
	String getRetMsg() {
		return retMsg;
	}
	void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	String getMsg() {
		return msg;
	}
	void setMsg(String msg) {
		this.msg = msg;
	}

	public String request(String msg){
		this.msg = msg;
		
		executeState(new WaitAnalyzeState());
		return retMsg;
	}
	
	void executeState(State state){
		state.handler(this);
	}
	
}
