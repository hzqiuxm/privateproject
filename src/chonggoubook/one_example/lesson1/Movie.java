package chonggoubook.one_example.lesson1;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/13 0013 13:52
 * 影片类，简单的数据类
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAT = 0;
    public static final int NEW_RELEASE = 1;


    private String title;
    private int priceCode;


    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
