package java8new.wangwenjun.streampdf.helloworld;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 13:52
 */
public abstract class FruitSelector {

    protected final static  String CANDIDATE_FRUIT = "apple";

    private List<Fruit> getData(){

        final List<Fruit> data = new ArrayList<Fruit>(){

            {
                add(new Fruit("apple",22.1));
                add(new Fruit("apple",22.2));
                add(new Fruit("apple",22.3));
                add(new Fruit("apple",22.4));
                add(new Fruit("apple",22.5));
                add(new Fruit("apple",22.6));
                add(new Fruit("apple",22.7));
                add(new Fruit("orange",22.8));
                add(new Fruit("orange",22.9));
                add(new Fruit("orange",23.0));
                add(new Fruit("orange",23.1));
                add(new Fruit("orange",24.2));
                add(new Fruit("orange",22.3));
                add(new Fruit("banana",22.4));
                add(new Fruit("banana",22.2));
                add(new Fruit("banana",22.2));
                add(new Fruit("banana",22.2));
                add(new Fruit("banana",22.2));
            }
        };

        return data;
    }


    //返回某个水果的价格集合
    public List<Double> select()
    {
        List<Fruit> fruits= getData();
        return doFilter(fruits);
    }

    protected abstract List<Double> doFilter(final List<Fruit> fruits);


}
