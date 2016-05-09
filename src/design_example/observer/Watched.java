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
            //注意在使用java的Observer模式的时候，这句话不可少
            setChanged();
        }

        //使用了拉的方式,默认将目标对象传给观察者对象
        notifyObservers();

        //也可以使用推方式，把需要的内容传给观察者
        //notifyObservers(Object org);
    }
}
