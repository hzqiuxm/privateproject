package design_example.factory.example2;
/**
 * 具体的创建器实现对象
 */
public class ConcreteCreator extends Creator {
	public Product factoryMethod() {
		//重定义工厂方法，返回一个具体的Product对象
		return new ConcreteProduct();
	}
}
