package design_example.observer.hot_water;

/**
 * Created by hzqiuxm on 2016/1/24 0024.
 */
public class Client {
    public static void main(String[] args) {
        Heater heater = new Heater();
        Display display = new Display();
        Alarm alarm = new Alarm();

        heater.addObserver(display);
        display.addObserver(alarm);

        heater.boilWater();
    }
}
