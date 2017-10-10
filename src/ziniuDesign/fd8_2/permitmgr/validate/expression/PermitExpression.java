package ziniuDesign.fd8_2.permitmgr.validate.expression;


public class PermitExpression extends AbstractExpression{
	private String expression = "";
	public PermitExpression(String expression, AbstractExpression ae) {
		super(ae);
		this.expression = expression;
	}
	public boolean interpret(Context ctx){
		//1��
		String perName = this.expression.substring("P:".length());
		//2:
		boolean f = ctx.getVs().hasPermit(ctx.getUserId(), ctx.getResourcePath(), perName);
		//3:
		ctx.setExpression(ctx.getExpression().replace(expression, ""+f));
		
		return super.interpret(ctx);
	}
	@Override
	public String toString() {
		return "PermitExpression [expression=" + expression + "]"+super.toString();
	}
	
}
