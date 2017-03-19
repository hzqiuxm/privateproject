package java6new;

/**
 * Created by qiuding on 2017/3/19.
 * 可变参数简单应用
 */
public class VariableParameter {

    public static void main(String[] args) {

        System.out.println(add(1,2,3,4));
        System.out.println(add(2,3,4));
    }

    //可变参数累加
    public static int add(int x, int... args){
        int sum = x;

//        for (int i = 0; i < args.length; i++) {
//            sum += args[i];
//        }

        //使用增强for循环的要求是集合变量必须是数组或实现了Iterable接口的集合类
        for (int arg : args) {
            sum += arg;
        }

        return sum;
    }
}
