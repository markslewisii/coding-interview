package com.bigo;

import java.util.HashMap;

public class ContainsCommonItem {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[] arr1 = { "Volvo", "BMW", "Ford", "Mazda" };
        String[] arr2 = { "Volvo1", "BMW1", "Ford1", "Mazda1" };

        boolean result = hasCommonItem(arr1, arr2);
        System.out.println(result);
    }

    public static boolean hasCommonItem(String[] a, String[] b) {
        HashMap<String, Boolean> lookup = new HashMap<String, Boolean>();

        // pack first array into hashmap
        for (String itema : a) {
            lookup.put(itema, true);
        }
        System.out.println(lookup);

        // now search
        for (String itemb : b) {
            if (lookup.getOrDefault(itemb, false) == true) {
                return true;
            }
        }
        return false;
    }

}
