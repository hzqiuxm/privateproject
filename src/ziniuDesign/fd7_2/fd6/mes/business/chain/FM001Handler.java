package ziniuDesign.fd7_2.fd6.mes.business.chain;


import ziniuDesign.fd7_2.fd6.l2.business.Constant;
import ziniuDesign.fd7_2.fd6.mes.business.vo.MsgVO;

public class FM001Handler extends MsgExecuteHandler{

	public FM001Handler(MsgExecuteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public String handlerRequest(MsgVO vo) {
		if(Constant.FM1.equals(vo.getMsgType())){
			//����
			System.out.println("now in FM001Handler==="+vo);
			
			return "Connect success";
		}
		return super.nextHandler(vo);
	}
}
