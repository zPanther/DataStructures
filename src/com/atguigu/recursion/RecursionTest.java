package com.atguigu.recursion;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-04-26 09:36
 **/
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
    }

    public static void test(int n){
        if( n > 2 ){
            test(n-1);
        }
        System.out.println("n=" + n);
    }
}
