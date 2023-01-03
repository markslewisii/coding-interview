package com.sort;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        // int[] testArr = { 6, 5, 3, 1, 8, 7, 2, 4 };
        int[] testArr = { 34, 4, 54, 600, 34, 65, 2345, 456, 34, 6526};
        System.out.println(Arrays.toString(mergeSort(testArr)));
    }

    
    // 1 3 5 6 7 8 2 4
    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        } else {
            return merge(mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2)),
                    mergeSort(Arrays.copyOfRange(arr,  arr.length/2, arr.length)));
        }
    }
    
    public static int[] merge(int[] arr1, int[] arr2) {
        
        
        int[] returnArray = new int[arr1.length + arr2.length];
        int arr1Index = 0;
        int arr2Index = 0;
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            if (arr1Index == arr1.length) { // roll in arr2
                returnArray[i] = arr2[arr2Index++];
            } else if (arr2Index == arr2.length) { // roll in arr1
                returnArray[i] = arr1[arr1Index++];
            } else if (arr1[arr1Index] < arr2[arr2Index]) {
                returnArray[i] = arr1[arr1Index++];
            } else {
                returnArray[i] = arr2[arr2Index++];
            }
        }
        System.out.println(String.format("%s %s => %s",
                Arrays.toString(arr1), 
                Arrays.toString(arr2),
                Arrays.toString(returnArray)));
        
        return returnArray;
    }
}
