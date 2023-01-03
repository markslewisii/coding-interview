package com.bigo;

import java.util.HashMap;
import java.util.Optional;

public class FirstRecurringNum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] exArr = {2,1,1,2,3,5,1,2,4};
        Integer result = firstDupe(exArr);
        
        if (result != null) {
            System.out.println(String.format("Dupe is %d", result));
        }
    }
    
    public static Integer firstDupe(int[] intArray) {
        HashMap<Integer, Boolean> table = new HashMap<>();
        Integer returnVal = null;
        Integer thisVal;
        for (int i = 0; i < intArray.length; i++) {
            thisVal = intArray[i];
            System.out.println(thisVal);
            if (Optional.ofNullable(table.get(thisVal)).orElse(false)) {
                return thisVal;
            } else {
                table.put(thisVal, true);
            }
        }
        
        return returnVal;
    }

}
