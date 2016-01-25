package design_example.observer.hot_water;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by hzqiuxm on 2016/1/24 0024.
 * 显示器，它是热水器的观察者，但是又是警报器的被观察者
 */
public class Display extends Observable implements Observer{
    private String state = "未开";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void displayTemputer(int temperature){
        if(temperature>95){
            this.setState("沸腾中......");
            this.setChanged();
            this.notifyObservers();
        }
        System.out.println("状态是："+ state + "温度是："+ temperature);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("arg ==== "+ arg);
        displayTemputer(((Heater)o).getTempertaure());
    }
}
