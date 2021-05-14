package com.atguigu.java;

/**
 * Author: CHENTAO
 * Date: 2021/5/14
 * Desc: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        int i,j,temp,t;
        if (low>high){
            return;
        }
        i = low;
        j = high;
        //temp是基准位
        temp = arr[low];
        while (i<j){
            //先看右边，依次往左边递减
            while (temp<=arr[j]&&i<j){
                j--;
            }
            //再看左边
            while (temp>arr[i]&&i<j){
                i++;
            }
            //如果满足则条件互换
            if (i<j){
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基为i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用 左半数组
        quickSort(arr,low,j-1);
        //递归调用 右半数组
        quickSort(arr,j+1,high);
    }
}

