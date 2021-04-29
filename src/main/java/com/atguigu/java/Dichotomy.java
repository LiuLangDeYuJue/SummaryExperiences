package com.atguigu.java;

public class Dichotomy {
    public static void main(String[] args) {
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            arr[i] = i;
        }
        System.out.println(linearSearch(arr,1000000));
        System.out.println(binarySearch(arr,1000000,0,100000000));
        System.out.println(loopBinarySearch(arr,1000000));
    }
    //todo 循环的方式实现二分法
    public static boolean loopBinarySearch(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (start<=end){
            mid =(start+end)/2;
            if (target>arr[mid]){
                start=mid+1;
            }else if (target<arr[mid]){
                end=mid-1;
            }else {
                return true;
            }
        }
        return false;
    }
    // todo 直接遍历
    public static boolean linearSearch(int[] arr,int target){
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==target){
                return true;
            }
        }
        return false;
    }
    //todo 递归实现二分法
    public static boolean binarySearch(int[] arr,int target,int start,int end){
        if (start<=end){
            int mid=(start+end)/2;
            if (target<arr[mid]){
                return binarySearch(arr,target,start,mid-1);
            }else if (target>arr[mid]){
                return binarySearch(arr,target,mid+1,end);
            }else {
                return true;
            }
        }
        return false;
    }
}
