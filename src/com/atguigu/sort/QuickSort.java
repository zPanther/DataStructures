package com.atguigu.sort;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-04 16:12
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot =  arr[(left+right)/2];
        int temp = 0;
        while ( l < r ){
            //在pivot的左边找到比它大于等于的数
            while ( arr[l] < pivot){
                l++;
            }
            while (arr[r] > pivot){
                r--;
            }
            if( l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }

        }
        if(l == r){
            l++;
            r--;
        }
        //向左递归
        if(left < r){
            quickSort(arr, left, r);
        }
        //向右递归
        if(right > l){
            quickSort(arr, l, right);
        }
    }
}
