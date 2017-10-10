package ziniuDesign.fd8_2.permitmgr.validate;

import ziniuDesign.fd8_2.permitmgr.spi.SPIFactory;
import ziniuDesign.fd8_2.permitmgr.spi.validate.ValidateSPI;
import ziniuDesign.fd8_2.permitmgr.validate.expression.*;

import java.util.ArrayList;
import java.util.List;


public class ValidateService implements IValidate{
	private ValidateSPI v = new SPIFactory().createSPIAbstractFactory().createValidateSPI();
	@Override
	public boolean hasPermit(int userId, String resourcePath, String permitName) {
		//1：resourcePath---resource Id
		int resId = v.getResourceIdByPath(resourcePath);
		//2: permitName ---- permit Id
		int perId = v.getPermitIdByName(permitName);
		//3：resource Id + permit Id ==〉ResourcePermit Id
		int rpId = v.getRPIdByResIdAndPerId(resId, perId);
		//4：userId  + ResourcePermit Id--> 结果
		int pdm = v.judgeUserPermit(userId, rpId);

		if(pdm>0){
			return true;
		}

		return false;
	}

	@Override
	public boolean hasPermitAnd(int userId, String resourcePath,
								List<String> permitNames) {

		for(String permitName : permitNames){
			if(!this.hasPermit(userId, resourcePath, permitName)){
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean hasPermitOR(int userId, String resourcePath,
							   List<String> permitNames) {
		for(String permitName : permitNames){
			if(this.hasPermit(userId, resourcePath, permitName)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isRole(int userId, String roleVerifyName) {
		int roleId = v.getRoleIdByVerifyName(roleVerifyName);

		int value = v.judgeUserRole(userId, roleId);

		if(value > 0){
			return true;
		}

		return false;
	}

	@Override
	public boolean isRole(int userId, List<String> roleVerifyNames) {
		for(String roleVerifyName : roleVerifyNames){
			if(this.isRole(userId, roleVerifyName)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasPermitByExpr(int userId, String resourcePath, String expr) {
		//构造抽象语法树
		String str = expr;
		str = str.replace("(","");
		str = str.replace(")","");
		str = str.replace("&&","");
		str = str.replace("||","");
		str = str.replace("!","");

		String[] ss = str.split(" ");


		List<String> list = new ArrayList<String>();
		for(String s : ss){
			if(s!=null && s.trim().length() > 0){
				list.add(s.trim());
			}
		}

		AbstractExpression ae = null;
		for(int i=list.size()-1;i>=0;i--){
			String s = list.get(i).trim();
			if(i==list.size()-1){
				if(s.startsWith("P:")){
					ae = new PermitExpression(s, new TerminalExpression(null));
				}else if(s.startsWith("R:")){
					ae = new RoleExpression(s, new TerminalExpression(null));
				}
			}else{
				if(s.startsWith("P:")){
					ae = new PermitExpression(s, ae);
				}else if(s.startsWith("R:")){
					ae = new RoleExpression(s, ae);
				}
			}
		}

		//调用抽象的语法树
		Context ctx = new Context(this,userId, resourcePath,expr);
		return ae.interpret(ctx);
	}
}

