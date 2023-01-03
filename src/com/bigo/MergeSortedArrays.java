package com.bigo;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // [0,3,4,31] [4,6,30]
        int[] a = {0,3,4,31, 55, 76};
        int[] b =  {4,6,30, 34, 68,69,74,76};
        
        int[] result = mergeSorted(a, b);
        System.out.println(Arrays.toString(result));
        
    }

    public static int[] mergeSorted(int[] arr1, int[] arr2) {
        int[] returnArr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int currentIndex = 0;
     
        while (i < arr1.length || j < arr2.length) {
            
            if (i >= arr1.length) {
                returnArr[currentIndex] = arr2[j++];
            } else if (j >= arr2.length) {
                returnArr[currentIndex] = arr1[i++];
            } else if (arr1[i] < arr2[j]) {
                returnArr[currentIndex] = arr1[i++];
            } else {
                returnArr[currentIndex] = arr2[j++];
            }
            currentIndex++;
        }
        
        return returnArr;
    }
}
