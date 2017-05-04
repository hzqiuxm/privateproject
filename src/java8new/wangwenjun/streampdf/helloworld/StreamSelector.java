package java8new.wangwenjun.streampdf.helloworld;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 14:43
 */
public class StreamSelector extends FruitSelector {
    @Override
    protected List<Double> doFilter(List<Fruit> fruits) {

        return fruits.stream().filter(fruit -> fruit.getName().equals(CANDIDATE_FRUIT))
                                .sorted(Comparator.comparing(Fruit::getPrice))
                                .map(Fruit::getPrice)
                                .collect(Collectors.toList());
    }
}
