package ziniuDesign.fd8_2.permitmgr.spi.validate;

public interface ValidateSPI {
	public int getResourceIdByPath(String resourcePath);
	public int getPermitIdByName(String permitName);
	public int getRPIdByResIdAndPerId(int resId, int perId);
	public int judgeUserPermit(int userId, int resAndPerId);
	
	public int getRoleIdByVerifyName(String verifyName);
	public int judgeUserRole(int userId, int roleId);
	
	
}
