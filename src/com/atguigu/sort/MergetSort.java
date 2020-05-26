package com.atguigu.sort;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-05 10:34
 **/
public class MergetSort {
    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];
        mergetSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));

    }
    //分+合
    public static void mergetSort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left+right)/2;
            //向左递归
            mergetSort(arr, left, mid, temp);
            //向右递归
            mergetSort(arr, mid+1, right, temp);
            //合并
            merget(arr, left, mid, right, temp);
        }
    }

    //合并
    public static void merget(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;//指向temp的当前索引

        //有序放入temp
        while (i <= mid && j<= right ){
            //
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //如果有剩余的需要处理
        while ( i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //将temp拷贝到arr
        t = 0;
        int templeft =  left;
        while (templeft <= right){
            arr[templeft] = temp[t];
            t++;
            templeft++;
        }
    }
}
