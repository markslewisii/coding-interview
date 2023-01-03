package com.bigo;

public class Boxes {

    static String searchItem = "box";
    static int numItems = 100000;
    static String[] boxes = new String[numItems];
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i = 0; i < numItems; i++) {
            boxes[i] = searchItem;
        }
        logFirstTwoBoxes(boxes);

    }
    
    
    // O(1) function
    private static void logFirstTwoBoxes(String[] arr) {
        long start = System.currentTimeMillis();
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        
    }
}
