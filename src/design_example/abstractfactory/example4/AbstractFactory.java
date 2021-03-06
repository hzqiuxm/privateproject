package design_example.abstractfactory.example4;

/**
 * 可扩展的抽象工厂的接口
 */
public interface AbstractFactory {
	/**
	 * 一个通用的创建产品对象的方法，为了简单，直接返回Object（存在一定安全隐患，因为需要强制转型，是一个运行期错误）
	 * 也可以为所有被创建的产品定义一个公共的接口
	 * @param type 具体创建的产品类型标识
	 * @return 创建出的产品对象
	 */
	public Object createProduct(int type);
}