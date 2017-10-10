package ziniuDesign.fd6_2.l2.messagetrans;


import ziniuDesign.fd6_2.l2.messagetrans.client.SendMsgProxy;

public class SendMsgFactory {
	private SendMsgFactory(){}
	
	public static ISendMsg createISendMsg(){
		return new SendMsgProxy();
	}

}
