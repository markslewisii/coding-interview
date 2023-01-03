package com.algo;

public class Factorial {

    public static void main(String[] args) {
        Integer factorial = 20;
        
        long loopStart = System.nanoTime();
        Integer loopResult = findFactorialLoop(factorial);
        long loopEnd = System.nanoTime();
        System.out.println(String.format("loop: %d, %d", loopResult, loopEnd - loopStart));
        
        long recursiveStart = System.nanoTime();
        Integer recursiveResult = findFactorialRecursive(factorial);
        long recursiveEnd = System.nanoTime();
        System.out.println(String.format("loop: %d, %d", recursiveResult, recursiveEnd - recursiveStart));
    }
    
    public static Integer findFactorialLoop(Integer num) {
        Integer returnval = 1;
        for(int i = num; i > 0; i--) {
            returnval = returnval * i;
        }
        return returnval;
    }
    
    public static Integer findFactorialRecursive(Integer num) {
        if (num == 1) {
            return 1;
        } else {
            return num * findFactorialRecursive(num - 1);
        }
    }

}
