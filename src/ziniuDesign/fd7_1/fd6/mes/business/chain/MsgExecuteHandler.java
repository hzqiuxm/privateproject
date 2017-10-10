package ziniuDesign.fd7_1.fd6.mes.business.chain;


import ziniuDesign.fd7_1.fd6.mes.business.vo.MsgVO;

public abstract class MsgExecuteHandler {
	private MsgExecuteHandler nextHandler;
	public MsgExecuteHandler(MsgExecuteHandler nextHandler){
		this.nextHandler = nextHandler;
	}
	
	public abstract String handlerRequest(MsgVO vo);
}
