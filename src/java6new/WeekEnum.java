package java6new;

/**
 * Created by qiuding on 2017/3/19.
 */
public enum WeekEnum {
    SUN(1),MON,TUE,WED,THI,FRI,STA;

    private WeekEnum(){
        System.out.println("无参");
    }

    private WeekEnum(int index){
        System.out.println("有参");
    }
}
