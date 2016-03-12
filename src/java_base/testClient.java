package java_base;

import java.util.HashSet;

/**
 * Created by hzqiuxm on 2016/3/12 0012.
 */
public class testClient {
    public static void main(String[] args) {
        HashSet<HashTest> hashSet = new HashSet<HashTest>();
        HashTest hashTest1 = new HashTest("hzqiuxm",(short) 30);
        HashTest hashTest2 = new HashTest("hzqiuxm",(short)30);
        hashSet.add(hashTest1);
        hashSet.add(hashTest2);
        System.out.println("HashSet大小是 ："+hashSet.size());
        hashTest1.setName("HZQIUXM");
        hashSet.remove(hashTest1);
        System.out.println("HashSet大小是 ："+hashSet.size());
        hashSet.clear();
        System.out.println("HashSet大小是 ："+hashSet.size());

    }
}
