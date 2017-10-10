package ziniuDesign.fd8_2.permitmgr.validate.expression;

public abstract class AbstractExpression {
	private AbstractExpression ae = null;
	
	public AbstractExpression(AbstractExpression ae){
		this.ae = ae;
	}
	public  boolean interpret(Context ctx){
		return this.ae.interpret(ctx);
	}
	@Override
	public String toString() {
		return "AbstractExpression [ae=" + ae + "]";
	}
	

}
