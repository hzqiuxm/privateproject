package ziniuDesign.fd7_2.fd6.mes.business.command;


import ziniuDesign.fd7_2.fd6.mes.business.vo.MsgVO;

public interface Command {
	public String execute(MsgVO vo);
}
