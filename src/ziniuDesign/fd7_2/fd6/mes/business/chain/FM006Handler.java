package ziniuDesign.fd7_2.fd6.mes.business.chain;


import ziniuDesign.fd7_2.fd6.mes.business.vo.MsgVO;

public class FM006Handler extends MsgExecuteHandler{

	public FM006Handler(MsgExecuteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public String handlerRequest(MsgVO vo) {
		
		return null;
	}
}
