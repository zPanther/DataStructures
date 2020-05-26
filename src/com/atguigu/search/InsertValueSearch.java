package com.atguigu.search;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-12 17:15
 **/
public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int index = insertValueSearch(arr, 0, arr.length-1, 100);
        System.out.println("index = " + index);
    }
    // 插值查找算法，需要数组有序.
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        if(left > right || findVal < arr[0] || findVal > arr[arr.length-1]){
            return -1;
        }
        //求出mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if(findVal > midValue){ //应该向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        }else if(findVal < midValue){
            return insertValueSearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
