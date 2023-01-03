package com.bigo;

import java.util.ArrayList;

public class MyStackArr<T> extends ArrayList<T> {
    
    public static void main(String[] args) {

        MyStackArr<Integer> stack = new MyStackArr<>(5);
        
        //System.out.println(stack.peek());
        stack.push(10);
        stack.push(15);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

    }

    public int length = 0;
    
    public MyStackArr(T val) {
        super();
        this.push(val);
        // this.top = new StackNode<T>(val);
        // this.bottom = this.top;
        this.length = this.size();
    }
    
    
    public T peek() {
        if (this.length == 0) {
            return null;
        }
        return this.get(length - 1);
    }

    
    public void push(T val) {
        this.add(val);
        this.length = this.size();
    }

    
    public T pop() {
        T returnVal = this.remove(length - 1);
        this.length = this.size();
        return returnVal;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("BOTTOM -> ");
        for (T i : this) {
            sb.append(String.format("(%s) -> ", i.toString()));
        }
        sb.append("<- TOP");
        return String.format("[%d nodes]: %s ", this.length, sb );
    }

    
}
