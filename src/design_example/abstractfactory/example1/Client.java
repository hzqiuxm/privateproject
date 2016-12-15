package design_example.abstractfactory.example1;

public class Client {
	public static void main(String[] args) {
		//创建装机工程师对象
		ComputerEngineer engineer = new ComputerEngineer();
		//告诉装机工程师自己选择的配件，让装机工程师组装电脑(存在的问题是CPU和主板是要按规定匹配的，不然是不可以使用的)
		engineer.makeComputer(1,2);
	}
}
