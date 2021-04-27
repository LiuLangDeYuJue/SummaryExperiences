package com.atguigu.java;

import java.util.HashMap;

//todo 递归实现爬楼梯问题
public class RecursiveOptimization {
    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        //System.out.println(fibonacci(45));                   //45 4222  50 44243   100  等不起
        //System.out.println(improvedFibonacci(3000));            //45 0  50 1  100  1   500  1
        System.out.println(cacheFibonacci(3000));            //45 1  50 1  100  1   500  1
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
    //递归实现
    // fib(100) = fib(99) + fib(98) = 2 * fib(98) + fib(97)会造成大量的重复计算
    public static Long fibonacci(int n){
        if (n==1||n==2){
            return (long)n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    //动态规划
    public static Long improvedFibonacci(int n){
        if (n==1||n==2){
            return (long)n;
        }
        Long[] arr = new Long[n + 1];
        arr[0]=0L;
        arr[1]=1L;
        arr[2]=2L;
        for (int i = 3; i <n+1 ; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
    //递归+缓存         预聚合和累加器
    public static HashMap<Integer,Long> cache = new HashMap<>();
    public static Long cacheFibonacci(int n){
        if (!cache.containsKey((n))){
            cache.put(n,fibHelp(n));   //求助函数
        }
        return cache.get(n);
    }

    private static Long fibHelp(int n) {
        if (n==1||n==2){
            return (long)n;
        }
        return cacheFibonacci(n-1)+cacheFibonacci(n-2);
    }
}
