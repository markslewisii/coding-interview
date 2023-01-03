package com.bigo;

public class BoxesN2 {

    static int[] boxes = new int[] {1,2,3,4,5,6,7,8};
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // O(n^2)
        for(int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes.length; j++) {
                System.out.println(boxes[i] + "," + boxes[j]);
            }
        }
    }
    
  
}
