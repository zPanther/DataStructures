package com.atguigu.sort;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-03 09:55
 **/
public class InsertSort {
    public static void main(String[] args) {
        int [] arr ={12,9,6,8};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i-1;

            while (insertIndex>=0 && insertValue < arr[insertIndex]){
                arr[insertIndex+1] =  arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1 != i){
                arr[insertIndex+1] = insertValue;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
