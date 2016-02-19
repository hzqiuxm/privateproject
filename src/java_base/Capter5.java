package java_base;

/**
 * Created by hzqiuxm on 2016/2/14 0014.
 * 枚举类
 */
public class Capter5 {

    public static void main(String[] args) {
        Capter5 c5 = new Capter5();
        c5.go(Direction.EAST);
//        c5.go(5);
//        c5.go(Color.BLUE);
    }

    public void go(Direction d){
        System.out.println("go to :" + d);
    }

    enum Direction{
        NORTH, SOURTH, EAST, WEST
    }

    enum Color{
        GREEN, RED, YELLOW, BLUE
    }

}
