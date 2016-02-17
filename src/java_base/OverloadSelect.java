package java_base;

/**
 * Created by hzqiuxm on 2016/2/17 0017.
 * 泛型方法重载例子
 * 注意这里的语法，方法前面的泛型符号<>只是对泛型的定义，不是方法函数的返回值
 */

class X{ }

class Y extends X{ }

public class OverloadSelect {


    public <T extends Y> void m(T t){
        System.out.println("<T extends Y> void  m(T t)");
    }

    public void m(X x){
        System.out.println("m(X x)");
    }

    public <T> void m(T t){
        System.out.println("m(T t)");
    }

    public static void main(String[] args) {
        Y y = new Y();
        OverloadSelect overloadSelect = new OverloadSelect();
        overloadSelect.m(y);
    }

}

