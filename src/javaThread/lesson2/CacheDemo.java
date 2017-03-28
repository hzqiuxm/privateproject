package javaThread.lesson2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/3/28 0028 20:23
 * 设计一个缓存系统
 */
public class CacheDemo {

    private Map<String,Object> cache= new HashMap<String,Object>();
    public static void main(String[] args) {



    }


    public Object getData(String key){

        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        rwl.readLock().lock();
        Object value;
        try {

            value = cache.get(key);

            if (value == null){
                rwl.readLock().unlock();
                rwl.writeLock().lock();

                if(value == null){
                    value = "hzqiuxm store some thing";
                }

                rwl.readLock().lock();
                rwl.writeLock().unlock();
            }

        } finally {

            rwl.readLock().unlock();
        }

        return value;
    }
}
