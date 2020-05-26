package com.atguigu.sort;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-05 14:09
 **/
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 12, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr){
        //找到最大数
        int max = arr[0];
        for (int l = 0; l < arr.length; l++) {
            if(arr[l]>max){
                max = arr[l];
            }
        }
        int  maxLength= (max+"").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int w = 0, n=1; w < maxLength; w++,n *= 10) {
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if(bucketElementCounts[j] != 0){
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketElementCounts[j] = 0;
            }
        }

    }
}
