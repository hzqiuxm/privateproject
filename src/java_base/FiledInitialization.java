package java_base;

/**
 * Created by qiuding on 16/2/18.
 * 变量初始化测试
 */
public class FiledInitialization {
    public FiledInitialization(int x, int y) {
        System.out.println("执行带参数构造器......");
        this.x = x;
        this.y = y;
    }

    {
        System.out.println("执行空的实例块初始化1......");
    }

    private int x = 3;
    private int y = initY();

    {
        System.out.println("执行实例化初始化2......");
        x = initX();
    }

    static {
        System.out.println("执行空的静态初始化块1......");
    }
    private static int staticX = 3;
    private static int staticY = initStaticY();

    static {
        System.out.println("执行静态初始化块2......");
        staticX = initStaticX();
    }
    public int initX(){
        System.out.println("执行实例变量x初始化......");
        return 1;
    }

    public int initY(){
        System.out.println("执行实例变量y初始化......");
        return 1;
    }
    public static int initStaticX(){
        System.out.println("执行静态变量staticX初始化......");
        return 2;
    }
    public static int initStaticY(){
        System.out.println("执行静态变量staticY初始化......");
        return 2;
    }
    public void show(){
        System.out.println(" x="+x + ", y="+y +", staticX="+staticX +", staticY="+staticY);
    }
    public static void main(String[] args) {
        FiledInitialization f1 = new FiledInitialization(10,20);
        FiledInitialization f2 = new FiledInitialization(15,30);
        f1.show();
        f2.show();
    }
}
