package ziniuDesign.fd7_2.fd6.mes.business.state;

import ziniuDesign.fd7_2.fd6.mes.business.vo.MsgVO;

import java.util.ArrayList;
import java.util.List;


public class WaitAnalyzeState implements State{

	@Override
	public void handler(Context ctx) {
		String msg = ctx.getMsg();
		
		String[] ss = msg.split(":");
		String msgType = ss[0];
		
		System.out.println("msgType=="+msgType);
		
		ss = ss[1].split(",");
		String l2Id = ss[0];
		
		List<String> list = new ArrayList<String>();
		
		if( ss.length > 1){
			ss = ss[1].split("\\|");
			for(String s : ss){
				list.add(s);
			}
		}
		
		MsgVO vo = new MsgVO();
		vo.setL2Id(l2Id);
		vo.setMsgType(msgType);
		vo.setPids(list);

		//设置回到context
		ctx.setMsgVO(vo);

		//需要执行流程的下一步
		ctx.executeState(new WaitExecuteState());
	}
}
