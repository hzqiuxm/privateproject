package java_base.firebug;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/9 0009 21:18
 */
public class U1 {

    Long id;
    String str;

    public U1(Long id, String str) {
        this.id = id;
        this.str = str;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "U1{" +
                "id=" + id +
                ", str='" + str + '\'' +
                '}';
    }
}
