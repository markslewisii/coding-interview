package com.sort;

import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        int[] testArr = { 4, 65, 5, 20, 34, 20, 5, 2 };
        System.out.println(Arrays.toString(selectionSort(testArr)));
    }

    public static int[] selectionSort(int[] arr) {
        Integer smallestIndex = null;
        Integer temp = null;
        for (int i = 0; i < arr.length; i++) {
            smallestIndex = i;
            for (int j = i; j < arr.length; j++) {
                
                if (smallestIndex == null || arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                    System.out.println(String.format("i: %d, j: %d; smallest: %d\n%s", 
                            i, 
                                    j, 
                                    smallestIndex,
                                    Arrays.toString(arr)));                }
            }
            temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
            System.out.println(String.format("swap:\n%s\n", Arrays.toString(arr)));
        }
        return arr;
    }
}
