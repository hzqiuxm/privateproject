package java8new;

/**
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2016/12/28 0028 15:52
 * 实现自定义接口
 */
public class Lambda2 {

    public static void main(String[] args) {

        new Action(){

            @Override
            public void execute(String content) {
                System.out.println(content);
            }
        }.execute("jdk1.8之前的匿名内部类实现方式，执行操作");

        Action login=(String content)->{
            System.out.println(content);
        };
        login.execute("jdk1.8的lambda实现的操作");

    }

    static interface  Action{
        void execute(String content);
    }
}
