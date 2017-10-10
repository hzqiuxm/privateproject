package ziniuDesign.fd8_2.permitmgr.validate;

import java.util.List;

public interface IValidate {
	public boolean hasPermit(int userId,String resourcePath,String permitName);
	/**
	 *
	 * @param userId
	 * @param resourcePath
	 * @param permitNames 同时有这多个权限
	 * @return
	 */
	public boolean hasPermitAnd(int userId,String resourcePath,List<String> permitNames);
	/**
	 *
	 * @param userId
	 * @param resourcePath
	 * @param permitNames 只要有这些权限中的一个就可以了
	 * @return
	 */
	public boolean hasPermitOR(int userId,String resourcePath,List<String> permitNames);


	public boolean isRole(int userId,String roleVerifyName);
	/**
	 *
	 * @param userId
	 * @param roleVerifyNames  只要有这些角色中的一个就可以了
	 * @return
	 */
	public boolean isRole(int userId,List<String> roleVerifyNames);



	/**
	 * 外观方法，一次性的解决几乎所有的验证需求
	 * @param userId
	 * @param resourcePath
	 * @param expr 要验证的权限组合的表达式
	 * @return
	 */

	// P:p1 || (P:p2 && P:p3))
	// R:r1 || (P:p1 || (P:p2 && P:p3))
	//1：使用Java的基本表达式的语法，只支持  && 、 || 、 !
	//2：在权限名称前加 P：， 在角色名称前加 R：
	public boolean hasPermitByExpr(int userId,String resourcePath,String expr);

//	R:r1                          true
//		P:p1                           false
//			P:p2                            true
//				P:p3                            false
//                Terminal      执行最后的 boolean 字符串  true || (false || (true && false))




}
