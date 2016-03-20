package java_base;

import java.util.*;

/**
 * Created by hzqiuxm on 2016/3/15 0015.
 */
public class ListTest2 {
    public static long addListFromHeader(List<Object> list){

        long startTime = System.currentTimeMillis();
        Object obj = new Object();
        for(int i=0; i<20000; i++){
            list.add(0,obj);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long searchListTime(List<Integer> list){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<20000; i++){
            Collections.binarySearch(list,list.get(i));
        }
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }


    public static void main(String[] args) {
        Integer arrayValue[] = new Integer[20000];
        Random random = new Random();
        for(int i=0; i<20000; i++){
            arrayValue[i] = random.nextInt(100) + 1;
        }
        List<Integer> values = Arrays.asList(arrayValue);

        System.out.println("ArrayList查询消耗时间: "+ ListTest2.searchListTime(new ArrayList<Integer>(values)));
        System.out.println("LinkedList查询消耗时间: "+ListTest2.searchListTime(new LinkedList<Integer>(values)));

        System.out.println("ArrayList插入消耗时间："+ ListTest2.addListFromHeader(new ArrayList<Object>()));
        System.out.println("LinkedList插入消耗时间："+ ListTest2.addListFromHeader(new LinkedList<Object>()));
    }
}
