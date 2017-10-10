package ziniuDesign.fd8_2.permitmgr.validate.expression;


import ziniuDesign.fd8_2.permitmgr.validate.ValidateService;

public class Context {
	private String expression;
	private int userId;
	private String resourcePath;
	private ValidateService vs = null;
	
	public Context(ValidateService vs,int userId, String resourcePath,String expression){
		this.expression = expression;
		this.userId = userId;
		this.resourcePath = resourcePath;
		this.vs = vs;
	}
	
	
	
	public ValidateService getVs() {
		return vs;
	}



	public int getUserId() {
		return userId;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}



	public String getExpression() {
		return expression;
	}	
}
