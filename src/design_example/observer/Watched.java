package design_example.observer;

import java.util.Observable;

/**
 * Created by hzqiuxm on 2016/1/24 0024.
 */
public class Watched extends Observable {
    private String data = "";

    public String retriveData(){
        return data;
    }
    public void changeData(String data){
        if(!this.data.equals(data)){
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }
}
