package java6new;

/**
 * Created by qiuding on 2017/3/19.
 * 比较复杂的枚举类
 */
public enum TrafficLamp {
    RED(20){//调用了带有参数的父类构造方法
        @Override
        public TrafficLamp nextLamp() {
            return GREEN;
        }
    },
    GREEN(30){
        @Override
        public TrafficLamp nextLamp() {
            return YELLOW;
        }
    },
    YELLOW(3){
        @Override
        public TrafficLamp nextLamp() {
            return RED;
        }
    };

    public abstract TrafficLamp nextLamp();
    private int time;
    private TrafficLamp(int time){

        this.time = time;
    }

    public int getTime(){
        return this.time;
    }

}
