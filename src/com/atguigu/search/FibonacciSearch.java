package com.atguigu.search;

import java.util.Arrays;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-05-13 11:06
 **/
public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int [] arr = {1,8,10,89,1000,1234};
    }

    //
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize ; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    //斐波那契查找算法
    public static int fibSearch(int[] a, int key){
        int low = 0;
        int high = a.length -1;
        int k = 0;
        int mid = 0;
        int f[] = fib();
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1){
            k++;
        }
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a,f[k]);
        for (int i = high+1; i < temp.length ; i++) {
            temp[i] =  a[high];
        }
        while (low <= high){
            mid = low + f[k-1]-1;
            if(key < temp[mid]){
                high = mid - 1;
                k--;
            }else if(key > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                if(mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
    
}
