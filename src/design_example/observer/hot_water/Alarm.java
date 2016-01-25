package design_example.observer.hot_water;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by hzqiuxm on 2016/1/24 0024.
 * 警告器，是显示器的观察者
 */
public class Alarm implements Observer{

    public void makeAlarm(){
        System.out.println("嘀嘀嘀......水开了！！！");
    }
    @Override
    public void update(Observable o, Object arg) {
        makeAlarm();
    }
}
