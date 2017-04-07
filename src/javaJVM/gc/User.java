package javaJVM.gc;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/7 0007 14:35
 */
public class User {

    private byte[] bytes = new byte[1024*1024];
    private String UserName;

    public User(String userName) {
        UserName = userName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                '}';
    }

    public void finalize(){
        System.out.println("finalize method is run !");
    }

}
