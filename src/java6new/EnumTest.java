package java6new;

/**
 * Created by qiuding on 2017/3/19.
 */
public class EnumTest {

    public static void main(String[] args) {

        WeekEnum weekEnum = WeekEnum.FRI;
        WeekEnum weekEnum1 = weekEnum.SUN;

        System.out.println(weekEnum);
        System.out.println(weekEnum1);

        TrafficLamp trafficLamp = TrafficLamp.GREEN;
        System.out.println(trafficLamp.nextLamp().getTime());
    }
}
