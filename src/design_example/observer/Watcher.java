package design_example.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by hzqiuxm on 2016/1/24 0024.
 */
public class Watcher implements Observer {

    public Watcher(Watched watched){
        watched.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Data has been changed to : "+ ((Watched)o).retriveData());
    }
}
