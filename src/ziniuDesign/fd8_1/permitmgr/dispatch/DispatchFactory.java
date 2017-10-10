package ziniuDesign.fd8_1.permitmgr.dispatch;

import ziniuDesign.fd8_1.permitmgr.dispatch.api.*;

public class DispatchFactory {
	private DispatchFactory(){}
	
	public static IPermit createIPermit(){
		return null;
	}
	public static IPermitDispatch createIPermitDispatch(){
		return null;
	}
	public static IResource createIResource(){
		return null;
	}
	public static IResourcePermit createIResourcePermit(){
		return null;
	}
	public static IRole createIRole(){
		return null;
	}
	public static IUser createIUser(){
		return null;
	}
	public static IUserRole createIUserRole(){
		return null;
	}
	
}
