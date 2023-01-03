package com.sort;

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int[] testArr = { 4, 65, 5, 20, 34, 20, 5, 2 };
        System.out.println(Arrays.toString(bubbleSort(testArr)));
    }

    public static int[] bubbleSort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.println(String.format("i: %d, j: %d; (%d > %d)\n%s", i, j, arr[j], arr[j + 1],
                            Arrays.toString(arr)));
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println(String.format("%s\n", Arrays.toString(arr)));
                }
            }
        }
        return arr;
    }
}
