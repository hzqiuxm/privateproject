package javaThread.wangwenjun.season3.jcu.atomic;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/12/12 0012 17:15
 * 引用类型其实也是Integer类型的，因为引用的只是在栈内存中保存引用的对象的地址
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {



    }

    static class Simole{

        private String name;
        private int age;

        public Simole(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

}
