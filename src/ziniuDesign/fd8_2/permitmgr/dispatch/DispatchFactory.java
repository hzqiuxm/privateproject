package ziniuDesign.fd8_2.permitmgr.dispatch;


import ziniuDesign.fd8_2.permitmgr.dispatch.api.*;
import ziniuDesign.fd8_2.permitmgr.dispatch.permit.PermitService;
import ziniuDesign.fd8_2.permitmgr.dispatch.permitdispatch.PermitDispatchService;
import ziniuDesign.fd8_2.permitmgr.dispatch.resource.ResourceService;
import ziniuDesign.fd8_2.permitmgr.dispatch.resourcepermit.ResourcePermitService;
import ziniuDesign.fd8_2.permitmgr.dispatch.role.RoleService;
import ziniuDesign.fd8_2.permitmgr.dispatch.user.UserService;
import ziniuDesign.fd8_2.permitmgr.dispatch.userrole.UserRoleService;

public class DispatchFactory {
	private DispatchFactory(){}
	
	public static IPermit createIPermit(){
		return new PermitService();
	}
	public static IPermitDispatch createIPermitDispatch(){
		return new PermitDispatchService();
	}
	public static IResource createIResource(){
		return new ResourceService();
	}
	public static IResourcePermit createIResourcePermit(){
		return new ResourcePermitService();
	}
	public static IRole createIRole(){
		return new RoleService();
	}
	public static IUser createIUser(){
		return new UserService();
	}
	public static IUserRole createIUserRole(){
		return new UserRoleService();
	}
	
}
