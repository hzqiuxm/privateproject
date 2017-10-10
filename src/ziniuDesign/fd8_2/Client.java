package ziniuDesign.fd8_2;

import ziniuDesign.fd8_2.permitmgr.dispatch.DispatchFactory;
import ziniuDesign.fd8_2.permitmgr.dispatch.api.*;
import ziniuDesign.fd8_2.permitmgr.dispatch.vo.*;
import ziniuDesign.fd8_2.permitmgr.validate.IValidate;
import ziniuDesign.fd8_2.permitmgr.validate.ValidateFactory;

import javax.script.ScriptException;


public class Client {
	public static void main(String[] args) throws ScriptException {
//		boolean f = "true || (false || (true && false))";

		//BeanShell
		//JRuby , JPython .....

		//js 引擎

//		ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
//		Object f = se.eval("true || (false || (true && false))");
//		System.out.println(f);

		IUser user = DispatchFactory.createIUser();
		UserModel um1 = new UserModel();
		um1.setId(1);
		um1.setName("u1");
		user.create(um1);

		UserModel um2 = new UserModel();
		um2.setId(2);
		um2.setName("u2");
		user.create(um2);

		UserModel um3 = new UserModel();
		um3.setId(3);
		um3.setName("u3");
		user.create(um3);
		/////////////////////////////////////
		IRole role = DispatchFactory.createIRole();
		RoleModel rm1 = new RoleModel();
		rm1.setId(11);
		rm1.setName("r1");
		rm1.setVerifyName("r1");
		role.create(rm1);

		RoleModel rm2 = new RoleModel();
		rm2.setId(12);
		rm2.setName("r2");
		rm2.setVerifyName("r2");
		role.create(rm2);
		///////////////////////////////////////////
		IUserRole ur = DispatchFactory.createIUserRole();
		UserRoleModel urm1 = new UserRoleModel();
		urm1.setId(21);
		urm1.setRoleId(11);
		urm1.setUserId(1);
		ur.create(urm1);

		UserRoleModel urm2 = new UserRoleModel();
		urm2.setId(22);
		urm2.setRoleId(12);
		urm2.setUserId(1);
		ur.create(urm2);

		UserRoleModel urm3 = new UserRoleModel();
		urm3.setId(23);
		urm3.setRoleId(11);
		urm3.setUserId(2);
		ur.create(urm3);

		UserRoleModel urm4 = new UserRoleModel();
		urm4.setId(24);
		urm4.setRoleId(12);
		urm4.setUserId(3);
		ur.create(urm4);
		/////////////////////////////////////////////////
		IResource r = DispatchFactory.createIResource();
		ResourceModel res1 = new ResourceModel();
		res1.setId(31);
		res1.setName("z1");
		res1.setPath("p1/p2");
		r.create(res1);

		ResourceModel res2 = new ResourceModel();
		res2.setId(32);
		res2.setName("z2");
		res2.setPath("p3/p4");
		r.create(res2);

		////////////////////////////////////////////////////
		IPermit ip = DispatchFactory.createIPermit();
		PermitModel pm = new PermitModel();
		pm.setId(41);
		pm.setName("p1");
		ip.create(pm);

		PermitModel pm2 = new PermitModel();
		pm2.setId(42);
		pm2.setName("p2");
		ip.create(pm2);
		////////////////////////////////////////////////////
		IResourcePermit irp = DispatchFactory.createIResourcePermit();
		ResourcePermitModel rpm1 = new ResourcePermitModel();
		rpm1.setId(51);
		rpm1.setPermitId(41);
		rpm1.setResourceId(31);
		irp.create(rpm1);

		ResourcePermitModel rpm2 = new ResourcePermitModel();
		rpm2.setId(52);
		rpm2.setPermitId(42);
		rpm2.setResourceId(31);
		irp.create(rpm2);

		ResourcePermitModel rpm3 = new ResourcePermitModel();
		rpm3.setId(53);
		rpm3.setPermitId(42);
		rpm3.setResourceId(31);
		irp.create(rpm3);
		///////////////////////////////////////////////////////
		IPermitDispatch ipd = DispatchFactory.createIPermitDispatch();
		PermitDispatchModel pdm1 = new PermitDispatchModel();
		pdm1.setId(61);
		pdm1.setUserOrRoleId(1);
		pdm1.setType(1);
		pdm1.setResourcePermitId(51);
		ipd.create(pdm1);

		PermitDispatchModel pdm2 = new PermitDispatchModel();
		pdm2.setId(62);
		pdm2.setUserOrRoleId(11);
		pdm2.setType(2);
		pdm2.setResourcePermitId(52);
		ipd.create(pdm2);

		PermitDispatchModel pdm3 = new PermitDispatchModel();
		pdm3.setId(63);
		pdm3.setUserOrRoleId(2);
		pdm3.setType(1);
		pdm3.setResourcePermitId(53);
		ipd.create(pdm3);

		PermitDispatchModel pdm4 = new PermitDispatchModel();
		pdm4.setId(64);
		pdm4.setUserOrRoleId(3);
		pdm4.setType(1);
		pdm4.setResourcePermitId(51);
		ipd.create(pdm4);
		/////////////////////////////////////////////////////

		IValidate iv = ValidateFactory.createIValidate();

//		boolean f = iv.hasPermit(1, "p1/p2","p2");

		boolean f = iv.hasPermitByExpr(1, "p1/p2", "!(((P:p1 || P:p2) && P:p3) || R:r1) && P:p1"); //iv.isRole(2, "r2"); //
		System.out.println("f=="+f);



	}
}
