package ziniuDesign.fd7_1.fd6.l2.messagetrans;


import ziniuDesign.fd7_1.fd6.l2.messagetrans.client.SendMsgProxy;

public class SendMsgFactory {
	private SendMsgFactory(){}
	
	public static ISendMsg createISendMsg(){
		return new SendMsgProxy();
	}

}
