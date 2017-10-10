package ziniuDesign.fd8_1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Client {
	public static void main(String[] args) throws ScriptException {
//		boolean f = "true || (false || (true && false))";

		//BeanShell
		//JRuby , JPython .....

		//js 引擎

		ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
		Object f = se.eval("true || (false || (true && false))");
		System.out.println(f);
	}
}
