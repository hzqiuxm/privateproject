package ziniuDesign.fd7_2.fd6.l2;

import ziniuDesign.fd7_2.fd6.l2.business.L2Factory;

import java.util.ArrayList;
import java.util.List;


public class Client {
	public static void main(String[] args) {
		L2Factory.createIL2().connectMes(123);
		L2Factory.createIL2().applyPDI(123);
		List<String> pdis = new ArrayList<String>();
		pdis.add("123");
		pdis.add("321");
		L2Factory.createIL2().applyPlan(123,pdis);
	}
}
