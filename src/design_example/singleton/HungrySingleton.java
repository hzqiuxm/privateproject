package design_example.singleton;

/**
 * Created by hzqixm on 2015/7/11.
 * 饥汉模式的单例示例
 * 思想：以时间换空间,是线程安全的JVM来保证
 */
public class HungrySingleton {

    //4.定义一个变量来存储实例对象
    //在这里初始化，在类加载的时候初始化只会保证创建一次（由JVM虚拟机保证）
    //5.因为这个变量要在静态方法中使用，所以也要声明为static
    private static HungrySingleton instance = new HungrySingleton();

    //1.私有化构造方法,只允许类内部控制创建实例的数目
    private HungrySingleton(){

    }

    //2.定义提供实例的方法
    //3.为这个方法加上static，否则会出现先有鸡还是先有蛋的问题
    public static HungrySingleton getInstance(){
        //6.返回存储的实例
        return instance;

    }

    public static void main(String[] args) {
        for (int i =0; i<3; i++) {
            System.out.println(HungrySingleton.getInstance());
        }
    }
}
