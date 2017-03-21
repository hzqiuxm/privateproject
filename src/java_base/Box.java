package java_base;

/**
 * Created by hzqiuxm on 2016/2/15 0015.
 * 对象是否相等比较实验
 */
public class Box {
    private int batch;

    public Box(int batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Box{" +
                "batch=" + batch +
                '}';
    }

    public static void main(String[] args) {
        Box box1 = new Box(1);
        Box box2 = new Box(1);

        System.out.println(box1.equals(box2));
        System.out.println(box1 == box2);
    }
}
