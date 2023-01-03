package com.bigo;

public class Nemo {

    static String searchItem = "nemo";
    static int numItems = 100000;
    static String[] nemo = new String[numItems];
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i = 0; i < numItems; i++) {
            nemo[i] = searchItem;
        }
        findNemo(nemo);

    }
    
    
    // O(n) function
    private static void findNemo(String[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("nemo")) {
                System.out.println("Found NEMO!");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        
    }
}
