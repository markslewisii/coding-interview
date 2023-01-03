package com.bigo;

public class ReverseString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(reverse("SysOut"));
    }
    
    public static String reverse(String str) {
        char[] reversedStr = new char[str.length()];
        for(int i = 0; i < str.length(); i++) {
            reversedStr[str.length() - 1 - i] = str.charAt(i);
        }
        
        return String.valueOf(reversedStr);
    }

}
