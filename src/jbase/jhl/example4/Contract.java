package jbase.jhl.example4;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/6/13 0013 10:25
 */
public class Contract {

    private int id;
    private String titleName;
    private String type;
    private int price;


    public Contract(int id, String titleName, String type, int price) {
        this.id = id;
        this.titleName = titleName;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
