package ziniuDesign.fd8_2.permitmgr.validate.expression;


public class RoleExpression extends AbstractExpression{
	private String expression = "";
	public RoleExpression(String expression, AbstractExpression ae) {
		super(ae);
		this.expression = expression;
	}
	public boolean interpret(Context ctx){
		//1��
		String roleVerifyName = this.expression.substring("R:".length());
		//2:
		boolean f = ctx.getVs().isRole(ctx.getUserId(), roleVerifyName);
		//3:
		ctx.setExpression(ctx.getExpression().replace(expression, ""+f));
		
		return super.interpret(ctx);
	}
	@Override
	public String toString() {
		return "RoleExpression [expression=" + expression + "]"+super.toString();
	}
	
}
