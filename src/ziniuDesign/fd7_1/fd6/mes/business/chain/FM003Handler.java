package ziniuDesign.fd7_1.fd6.mes.business.chain;


import ziniuDesign.fd7_1.fd6.mes.business.vo.MsgVO;

public class FM003Handler extends MsgExecuteHandler{

	public FM003Handler(MsgExecuteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public String handlerRequest(MsgVO vo) {
		//1：判断类型
		//2：调用ps系统，可能会比较复杂，而且还有很多其他的系统也调用ps
		//如果直接在这里实现调用ps，就不太合适
		//可以引入命令模式，只管发出命令
		//3：
		//4：
		//5：


		return null;
	}
}
