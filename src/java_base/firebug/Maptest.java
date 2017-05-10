package java_base.firebug;

import java.util.HashMap;
import java.util.Map;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/10 0010 15:33
 */
public class Maptest {

    public static void main(String[] args) {

        HashMap<String,MapModle> emap = new HashMap<>();


        MapModle interUser = new MapModle();
        HashMap<String,U1> hm = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            U1 u = new U1(1l,"hzqiuxm"+i);

            hm.put(i+"id",u);

        }

        for (int j = 0; j < 10; j++) {
            interUser.setUser(hm);
        }

        removeOPt(interUser);

    }

    public static void removeOPt(MapModle mapModle){

        Map<String,U1> user = mapModle.getUser();
        System.out.println("-------------------1---------------------");

        user.values().stream().forEach(val-> System.out.println(val));


//        for (String key : user.keySet()){
//            user.get(key).setStr(null);
//        }

        mapModle.getUser().values().stream().forEach(val->val.setStr(null));

        System.out.println("-------------------2---------------------");

        user.values().stream().forEach(val-> System.out.println(val));

        System.out.println("--------------------3--------------------");


        Map<String,U1> user2 = mapModle.getUser();
        user2.values().stream().forEach(val-> System.out.println(val));






    }
}
