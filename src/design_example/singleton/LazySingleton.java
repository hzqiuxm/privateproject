package design_example.singleton;

import org.apache.log4j.Logger;

/**
 * Created by hzqixm on 2015/7/11.
 * 懒汉模式单例示例
 * 思想：以空间换时间，线程不安全的
 */
public class LazySingleton {
    private static final Logger log = Logger.getLogger(LazySingleton.class);
    //4.定义一个变量来存储实例对象
    //5.因为这个变量要在静态方法中使用，所以也要声明为static
    private static LazySingleton instance = null;

    //1.私有化构造方法,只允许类内部控制创建实例的数目
    private LazySingleton(){

    }

    //2.定义提供实例的方法
    //3.为这个方法加上static，否则会出现先有鸡还是先有蛋的问题
    public static LazySingleton getInstance(){
        //6.判断存储实例是否已创建过，有直接返回，没有就先创建再返回
        if(null==instance){
            instance = new LazySingleton();
        }

        return instance;

    }


    public static void main(String[] args) {

        for (int i=0; i<3; i++) {
            System.out.println(LazySingleton.getInstance());
        }
    }
}
