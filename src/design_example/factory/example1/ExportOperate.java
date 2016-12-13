package design_example.factory.example1;
/**
 * 实现导出数据的业务功能对象
 */
public class ExportOperate {
	/**
	 * 导出文件
	 * @param type 用户选择的导出类型
	 * @param data 需要保存的数据
	 * @return 是否成功导出文件
	 */
	public boolean export(int type,String data){
		//先完成各种导出数据前的准备工作
		//比如进行数据校验
		System.out.println("now 进行数据校验");
		//比如进行数据转换
		System.out.println("now 进行数据转换");
		//比如进行数据格式的封装
		System.out.println("now 进行数据格式的封装");

		//然后才真正的去导出
		ExportFileApi api = null;
		//根据类型来选择究竟要创建哪一种导出文件对象
		//缺点：1 职责不明确，这里只需要使用到api，不用关心创建
		// 	   2 违反了开闭原则，每次新增一种导出方式都需要修改该类
		// 	   3客户端使用的时候必须要知道type传什么值，且并没有也不好处理不存在的值
		if(type == 1){
			api = new ExportTxtFile();
		}else if(type == 2){
			api = new ExportDB();
		}else if(type==3){
			api = new ExportXmlFile();
		}
		return api.export(data);
	}
}
