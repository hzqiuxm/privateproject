package java6new;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/20 0020 10:06
 */
public class ReflectPoint {

    public int y;
    public String str1 = "hall";
    public String str2 = "babababala";
    private int x;

    public ReflectPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ReflectPoint(int y, String str1, String str2, int x) {
        this.y = y;
        this.str1 = str1;
        this.str2 = str2;
        this.x = x;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "ReflectPoint{" +
                "y=" + y +
                ", str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", x=" + x +
                '}';
    }
}
