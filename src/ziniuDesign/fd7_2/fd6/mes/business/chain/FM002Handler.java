package ziniuDesign.fd7_2.fd6.mes.business.chain;


import ziniuDesign.fd7_2.fd6.l2.business.Constant;
import ziniuDesign.fd7_2.fd6.mes.business.vo.MsgVO;

public class FM002Handler extends MsgExecuteHandler{

	public FM002Handler(MsgExecuteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public String handlerRequest(MsgVO vo) {
		if(Constant.FM2.equals(vo.getMsgType())){
			//����
			System.out.println("now in FM002Handler==="+vo);
			
			return "Heart beat success";
		}
		return super.nextHandler(vo);
	}
}
