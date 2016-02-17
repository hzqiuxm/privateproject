package java_base;

/**
 * Created by hzqiuxm on 2016/2/17 0017.
 */
public class MainInvocation {
    private static boolean hasInit = false;
    private static int i;
    public static void main(String[] args) {
        init(args.length-1);
        if(i >= 0){
            print(args);
        }
    }

    public static void print(String[] s){
        System.out.println(s[i--]);
        main(s);
    }

    public static void init(int value){
        if(!hasInit){
            hasInit = true;
            i = value;
        }
    }
}
