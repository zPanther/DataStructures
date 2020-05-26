package com.atguigu.sort;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

/**
 * @program: DataStructures
 * @description:
 * @author: zhaifantasy
 * @create: 2020-04-18 18:22
 **/
public class SelectSort {
    public static void main(String[] args) {
        String[] s = {"f"};
        System.out.println(common(s));


    }

    public static String common(String[] string) {
        if (string == null || string.length == 0) {
            return "";
        }
        if (string.length == 1) {
            return string[0];
        }

        String samll = string[0];
        for (int i = 0; i < string.length; i++) {
            if(samll.length()>string[i].length()){
                samll=string[i];
            }
        }

        for(int i=0;i<samll.length();i++){
            for(int j=0;j<string.length;j++){
                if(samll.charAt(i)!=string[j].charAt(i)){
                    return samll.substring(0,i);
                }
            }
        }

        return samll;
    }

}
