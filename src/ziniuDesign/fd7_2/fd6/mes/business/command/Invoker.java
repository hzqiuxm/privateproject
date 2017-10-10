package ziniuDesign.fd7_2.fd6.mes.business.command;


import ziniuDesign.fd7_2.fd6.mes.business.vo.MsgVO;

public class Invoker {
	public enum CommandType{
		Call_PS_PDIS,Call_PS_Produce,Call_PS_Produce_Adjust
	}
	
	public String runCommand(MsgVO vo, CommandType ct){
		Command command = null;
		if(ct.equals(CommandType.Call_PS_PDIS)){
			command = new CallPDISCommand();
		}else if(ct.equals(CommandType.Call_PS_Produce)){
			//
		}else if(ct.equals(CommandType.Call_PS_Produce_Adjust)){
			//
		}		
		
		return command.execute(vo);
	}
}
