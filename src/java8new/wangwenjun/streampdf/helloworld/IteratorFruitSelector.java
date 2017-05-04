package java8new.wangwenjun.streampdf.helloworld;

import java.util.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 13:59
 */
public class IteratorFruitSelector  extends FruitSelector{
    @Override
    protected List<Double> doFilter(List<Fruit> fruits) {

        //返回苹果
        List<Fruit> appleList = new ArrayList<>();

        Iterator<Fruit> iterator = fruits.iterator();
        for (; iterator.hasNext();) {
            Fruit fruit = iterator.next();
            if(fruit.getName().equals(CANDIDATE_FRUIT)){
                appleList.add(fruit);
            }
        }

        //按价格排序
        Collections.sort(appleList,((o1, o2) -> {
            if (o1.getPrice() >o2.getPrice()) return 1;
            else if(o1.getPrice() == o2.getPrice()) return 0;
            else return -1;

        }));

        //获得苹果价格集合
        List<Double> applepriceList = new ArrayList<>();
        for (Fruit apple : appleList){
            applepriceList.add(apple.getPrice());
        }

        return applepriceList;

    }
}
