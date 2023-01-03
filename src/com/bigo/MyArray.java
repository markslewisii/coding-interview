package com.bigo;

import java.util.ArrayList;

public class MyArray {

    private int length;
    private ArrayList<String> data;
    
    public MyArray() {
        this.length = 0;
        this.data = new ArrayList<>();        
    }
    
    public String get(int index) {
        return this.data.get(index);
    }
    
    public void push(String item) {
        this.data.add(item);
        this.length++;
    }
    
    public String pop() {
        String returnItem = this.data.get(length - 1);
        this.data.remove(length - 1);
        this.length--;
        return returnItem;
    }
    
    public String delete(int index) {
        return this.shiftItems(index);
    }
    
    private String shiftItems(int index) {
        String deletedValue = this.data.get(index);
        for(var i = index; i < length - 1; i++) {
            this.data.set(i, this.data.get(i+1));
        }
        this.data.remove(length - 1);
        length--;
        
        return deletedValue;
    }
    
    public String toString() {
        return String.format("length : %d\ndata : %s",this.length, this.data.toString());
    }
}