package com.bigo;
import java.util.ArrayList;

public class SpaceComplexity {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1,2,3,4,5};
        // booooo(nums);
        arrayOfHiNTimes(6);
    }
    
    public static void booooo(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.println("boooo!");
        }
    }
    
    public static void arrayOfHiNTimes(int n) {
        ArrayList<Integer> arl = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            System.out.println("ArrayList!");
        }
        
    }

}
