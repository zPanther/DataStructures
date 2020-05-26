package com.atguigu.sort;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-04-18 19:55
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(jump(3));
    }

    public static int jump(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else {
            return 2 * jump(n - 1);
        }
    }
}
