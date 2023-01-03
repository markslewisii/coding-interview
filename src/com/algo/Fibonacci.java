package com.algo;

import java.util.HashMap;

public class Fibonacci {

    public static Integer recursiveIndex = 0;
    public static Integer thisFibValue = 0;
    public static Integer nextFibValue = 1;
    private Integer numCalc = 0;
    
    public Integer getNumCalc() {
        return numCalc;
    }

    public void setNumCalc(Integer numCalc) {
        this.numCalc = numCalc;
    }

    private HashMap<Integer, Integer> cache;
    
    public static void main(String[] args) {
        Integer fibTargetIndex = 30;
        Fibonacci fibObj = new Fibonacci();
       
        fibObj.resetCounter();
        long loopStart = System.nanoTime();
        Integer loopResult = fibObj.findFibonacciLoop(fibTargetIndex);
        long loopEnd = System.nanoTime();
        System.out.println(String.format("result: %d, time: %d, iterations: %d", loopResult, loopEnd - loopStart, fibObj.getNumCalc()));
        
        fibObj.resetCounter();
        long recursiveStart = System.nanoTime();
        Integer recursiveResult = fibObj.findFibonacciRecursive(fibTargetIndex);
        long recursiveEnd = System.nanoTime();
        System.out.println(String.format("result: %d, time: %d, iterations: %d", recursiveResult, recursiveEnd - recursiveStart, fibObj.getNumCalc()));
        
        fibObj.resetCounter();
        long recursiveCacheStart = System.nanoTime();
        Integer recursiveCacheResult = fibObj.findFibonacciRecursiveCached(fibTargetIndex);
        long recursiveCacheEnd = System.nanoTime();
        System.out.println(String.format("result: %d, time: %d, iterations: %d", recursiveCacheResult, recursiveCacheEnd - recursiveCacheStart, fibObj.getNumCalc()));
    }
    
    public Fibonacci() {
        this.cache = new HashMap<Integer, Integer>();
    }
    
    
    public void resetCounter() {
        this.numCalc = 0;
    }
    
    public Integer findFibonacciLoop(Integer num) {
        Integer thisSeq = 0;
        Integer nextSeq = 1;
        Integer temp = null;
        for(int i = 0; i < num; i++) {
            this.numCalc++;
            temp = thisSeq + nextSeq;
            thisSeq = nextSeq;
            nextSeq = temp;
        }
        return thisSeq;
    }
    
    public Integer findFibonacciRecursive(Integer index) {
        this.numCalc++;
        if (index < 2) {
            return index;
        } else {
            return findFibonacciRecursive(index - 1) + findFibonacciRecursive(index - 2);
        }
    }
    
    public Integer findFibonacciRecursiveCached(Integer index) {
        if (this.cache.get(index) != null) {
            return cache.get(index);
        } else if (index < 2) {
            return index;
        } else {
            this.numCalc++;
            this.cache.put(index, this.findFibonacciRecursiveCached(index - 1) + this.findFibonacciRecursiveCached(index - 2));
            return this.cache.get(index);
        }
    }

    
}
