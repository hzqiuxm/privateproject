package ziniuDesign.fd7_1.fd6.mes.business.state;

public class WaitExecuteState implements State{

	@Override
	public void handler(Context ctx) {
		//这里问题：不知道具体是什么消息，也不知道应该如何处理， State只是用来控制基本的流程

		//把消息及其数据 扔到一个职责链里面，由职责链里面的对象自己去对号入座，进行相应的业务处理

		//1：要组装链
		//2：要有一个入口

	}
}
