package com.bigo;

public class ArrayOperations {

    public static void main(String[] args) {
        MyArray newArray = new MyArray();
        newArray.push("hi");
        newArray.push("you");
        newArray.push("!");
        System.out.println(newArray);
        System.out.println(newArray.delete(2));
        newArray.push("are");
        newArray.push("nice");
        System.out.println(newArray);
    }

}
