package com.sort;

import java.util.Arrays;

public class Inertionsort {
    public static void main(String[] args) {
        // int[] testArr = { 6, 5, 3, 1, 8, 7, 2, 4 };
        int[] testArr = { 34, 4, 54, 600, 34, 65, 2345, 456, 34, 6526};
        System.out.println(Arrays.toString(insertionSort(testArr)));
    }

    
    // 1 3 5 6 7 8 2 4
    public static int[] insertionSort(int[] arr) {
        Integer valToMove = null;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                valToMove = arr[i];
                for(int j = i; j >= 0; j--) {
                    if (j == 0) {
                        arr[0] = valToMove;
                    } else if (valToMove > arr[j-1]) {
                        arr[j] = valToMove;
                        break;
                    } else {
                        arr[j] = arr[j-1];
                    }
                }
                System.out.println(String.format("i: %d; %s", 
                        i, 
                                Arrays.toString(arr)));
            }
        }
        return arr;
    }
}
