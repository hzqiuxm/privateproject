package algorithm;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/4/13 0013 19:06
 * 堆排序
 */
public class HeapSortTest {

    public static void main(String[] args) {

        int[] data = new int[] {5,3,6,2,1,9,4,8,7};
        print(data);
        heapSort(data);
        System.out.println("------------");
        print(data);

    }


    public static void heapSort(int[] data){

        for (int i = 0; i < data.length; i++) {
            createMaxHeap(data,data.length-1-i);
            swap(data,0,data.length-1-i);
            print(data);
        }
    }

    //交换两个数值大小
    public static void swap(int[] data, int i, int j){
        if (i == j){
            return;
        }

        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    //创建大堆算法
    public static void createMaxHeap(int[] data, int lastIndex){
        for (int i = (lastIndex-1)/2; i >=0 ; i--) {
            //保存当前正在判断的节点
            int temp = i;

            //若左节点存在
            while (2*temp+1 <= lastIndex){
                int bigestIndex = 2*temp +1; //根节点0 左孩子2k+1 右孩子 2k+2 根节点1 做左孩子2k  右孩子2k+1

                //若右节点存在,且大于左节点，最大值为右节点
                if(bigestIndex < lastIndex){
                    if (data[bigestIndex] < data[bigestIndex + 1]){
                        bigestIndex++;
                    }
                }

                //当前节点的值小于最大值，交换
                if(data[temp] < data[bigestIndex]){
                    swap(data,temp,bigestIndex);
                    temp = bigestIndex;
                }else {
                    break;
                }

            }

        }
    }

    public static void print(int[] data){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }


}
