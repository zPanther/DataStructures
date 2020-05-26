package com.atguigu.sort;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-03 16:29
 **/
public class ShellSort {
    public static void main(String[] args) {
        int [] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length/2 ; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >= 0; j-=gap) {
                    if(arr[j]>arr[j+gap]){
                        temp = arr[j];
                        arr[j] =  arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort2(int[] arr) {
        for (int gap = arr.length/2 ; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j-gap]){
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = temp;

            }
        }
    }

}
