package design_example.observer.hot_water;

import java.util.Observable;

/**
 * Created by hzqiuxm on 2016/1/24 0024.
 * 热水器类，被观察者
 */
public class Heater extends Observable {
    private int tempertaure;

    public int getTempertaure() {
        return tempertaure;
    }

    public void setTempertaure(int tempertaure) {
        this.tempertaure = tempertaure;
    }

    public void boilWater(){
        for (int i = 90; i < 100; i++) {
            tempertaure = i;
            this.setChanged();
            this.notifyObservers(tempertaure);
        }
    }
}
