package java_base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hzqiuxm on 2016/3/12 0012.
 */
public class ListTest {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("test1","test2","test3");
        List<String> list2 = Arrays.asList("test2","test3","test4");
        //交集
        List<String> listjj = new ArrayList<String>();
        listjj.addAll(list1);
        listjj.retainAll(list2);
        for(String str : listjj){
            System.out.println("交集 = "+ str);
        }

        //差集
        List<String> listcj = new ArrayList<String>();
        listcj.addAll(list1);
        listcj.removeAll(list2);
        for(String str : listcj){
            System.out.println("list1-list2差集 = "+ str);
        }

        //并集
        List<String> listbj = new ArrayList<String>();
        listbj.addAll(list1);
        listbj.removeAll(list2);
        listbj.addAll(list2);
        for(String str : listbj){
            System.out.println("并集 = "+ str);
        }
    }

}
