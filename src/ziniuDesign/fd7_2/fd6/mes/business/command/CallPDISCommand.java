package ziniuDesign.fd7_2.fd6.mes.business.command;


import ziniuDesign.fd7_2.fd6.mes.business.vo.MsgVO;

public class CallPDISCommand implements Command{

	@Override
	public String execute(MsgVO vo) {
		System.out.println("now call ps===="+vo);
		
		int a = (int)(1 + Math.random() * 10);
		
		return a+"|"+(a+1)+"|"+(a+2)+"|"+(a+3);
	}
}
