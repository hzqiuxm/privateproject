package ziniuDesign.fd7_2.fd6.mes.business.state;


import ziniuDesign.fd7_2.fd6.mes.business.chain.*;

public class WaitExecuteState implements State {

	@Override
	public void handler(Context ctx) {
		// 这里问题：不知道具体是什么消息，也不知道应该如何处理， State只是用来控制基本的流程
		// 把消息及其数据 扔到一个职责链里面，由职责链里面的对象自己去对号入座，进行相应的业务处理
		// 1：要组装链
		// 2：要有一个入口

		MsgExecuteHandler handler = new FM001Handler(new FM002Handler(
				new FM003Handler(new FM004Handler(new FM005Handler(
						new FM006Handler(new FM007Handler(null)))))));
		
		String ret = handler.handlerRequest(ctx.getMsgVO());
		
		ctx.setRetMsg(ret);
		
		ctx.executeState(new WaitPrepareReturnMsgState());		
	}

}
