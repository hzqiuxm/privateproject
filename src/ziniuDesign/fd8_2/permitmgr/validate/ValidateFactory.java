package ziniuDesign.fd8_2.permitmgr.validate;

public class ValidateFactory {
	private ValidateFactory(){}
	public static IValidate createIValidate(){
		return new ValidateService();
	}
}
