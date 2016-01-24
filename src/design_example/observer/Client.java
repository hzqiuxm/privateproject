package design_example.observer;

/**
 * Created by hzqiuxm on 2016/1/24 0024.
 */
public class Client {

    static private Watched watched;
    static private Watcher watcher;

    public static void main(String[] args) {
        watched = new Watched();
        watcher = new Watcher(watched);

        watched.changeData("我来改变一下看看");
        watched.changeData("我再来改变一下看看");
    }
}
