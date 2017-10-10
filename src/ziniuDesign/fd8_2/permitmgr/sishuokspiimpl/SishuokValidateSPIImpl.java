package ziniuDesign.fd8_2.permitmgr.sishuokspiimpl;

import ziniuDesign.fd8_2.permitmgr.dispatch.vo.*;
import ziniuDesign.fd8_2.permitmgr.spi.validate.ValidateSPI;

import java.util.List;


public class SishuokValidateSPIImpl implements ValidateSPI {

	@Override
	public int getResourceIdByPath(String resourcePath) {
		SishuokDispatchDAOImpl impl = new SishuokDispatchDAOImpl<ResourceModel>();
		ResourceModel rm = new ResourceModel();
		rm.setPath(resourcePath);
		 
		List<ResourceModel> list = impl.getByCondition(rm,0,0);
		
		if(list!=null && list.size()>0){
			ResourceModel resourceModel = list.get(0);
			return resourceModel.getId();
		}
		
		return 0;
	}

	@Override
	public int getPermitIdByName(String permitName) {
		SishuokDispatchDAOImpl impl = new SishuokDispatchDAOImpl<PermitModel>();
		PermitModel pm = new PermitModel();
		pm.setName(permitName);
		 
		List<PermitModel> list = impl.getByCondition(pm,0,0);
		
		if(list!=null && list.size()>0){
			PermitModel permitModel = list.get(0);
			return permitModel.getId();
		}
		return 0;
	}

	@Override
	public int getRPIdByResIdAndPerId(int resId, int perId) {
		SishuokDispatchDAOImpl impl = new SishuokDispatchDAOImpl<ResourcePermitModel>();
		ResourcePermitModel rpm = new ResourcePermitModel();
		
		rpm.setPermitId(perId);
		rpm.setResourceId(resId);
		
		List<ResourcePermitModel> list = impl.getByCondition(rpm,0,0);
		
		if(list!=null && list.size()>0){
			ResourcePermitModel rpm2 = list.get(0);
			return rpm2.getId();
		}
		return 0;
	}

	@Override
	public int judgeUserPermit(int userId, int resAndPerId) {
		SishuokDispatchDAOImpl impl = new SishuokDispatchDAOImpl<PermitDispatchModel>();
		PermitDispatchModel rm = new PermitDispatchModel();
		rm.setUserOrRoleId(userId);
		rm.setType(1);
		rm.setResourcePermitId(resAndPerId);
		
		List<PermitDispatchModel> list = impl.getByCondition(rm,0,0);
		
		if(list!=null && list.size()>0){
			PermitDispatchModel rm2 = list.get(0);
			return rm2.getId();
		}		
		return 0;
	}

	@Override
	public int getRoleIdByVerifyName(String verifyName) {
		SishuokDispatchDAOImpl impl = new SishuokDispatchDAOImpl<RoleModel>();
		RoleModel rm = new RoleModel();
		rm.setVerifyName(verifyName);
		
		List<RoleModel> list = impl.getByCondition(rm,0,0);
		
		if(list!=null && list.size()>0){
			RoleModel rm2 = list.get(0);
			return rm2.getId();
		}
		return 0;
	}

	@Override
	public int judgeUserRole(int userId, int roleId) {
		SishuokDispatchDAOImpl impl = new SishuokDispatchDAOImpl<UserRoleModel>();
		UserRoleModel urm = new UserRoleModel();
		urm.setRoleId(roleId);
		urm.setUserId(userId);
		
		List<UserRoleModel> list = impl.getByCondition(urm,0,0);
		
		if(list!=null && list.size()>0){
			UserRoleModel urm2 = list.get(0);
			return urm2.getId();
		}
		return 0;
	}

}
