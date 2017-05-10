package java_base.firebug;

import java.util.Map;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/10 0010 15:40
 */
public class MapModle {

    private Map<String ,U1> user;

    public Map<String, U1> getUser() {
        return user;
    }

    public void setUser(Map<String, U1> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "MapModle{" +
                "user=" + user +
                '}';

    }
}
