package com.atguigu.sort;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-01 10:09
 **/
public class BubbleSortAgain {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};
        bubbleSort(arr);

    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j+1] ;
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(!flag){
                break;
            }else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
