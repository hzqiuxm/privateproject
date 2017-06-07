package java8new.wangwenjun.Collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2017/5/27 0027 15:42
 * Collector接口
 *public interface Collector<T, A, R> {
 *      Supplier<A> supplier();
 *      BiConsumer<A, T> accumulator();
 *      BinaryOperator<A> combiner();
 *      Function<A, R> finisher();
 *      Set<Characteristics> characteristics();
 *}
 * T是Stream元素类型
 */
public class MyToListCollector<T> implements Collector<T,List<T>,List<T>> {

    private void log(final String log){
        System.out.println(Thread.currentThread().getName() + "====" + log);
    }

    @Override
    public Supplier<List<T>> supplier() {
        log("supplier");
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        log("accumulator");
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        log("combiner");
        return (l1,l2)->{
            l1.addAll(l2);
            return l1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        log("finisher");
        return Function.identity();
    } //等同于 return t->t

    @Override
    public Set<Characteristics> characteristics() {
        log("characteristics");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.CONCURRENT));
    }
}
