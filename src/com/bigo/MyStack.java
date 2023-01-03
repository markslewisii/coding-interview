package com.bigo;

public class MyStack<T> {
    
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>(5);
        
        //System.out.println(stack.peek());
        stack.push(10);
        stack.push(15);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

    }

    public StackNode<T> top;
    public StackNode<T> bottom;
    public int length = 0;
    
    public MyStack(T val) {
        this.push(val);
        // this.top = new StackNode<T>(val);
        // this.bottom = this.top;
        this.length++;
    }
    
    
    public T peek() {
        if (this.length == 0) {
            return null;
        }
        return this.top.getVal();
    }

    
    public void push(T val) {
        StackNode<T> newNode = new StackNode<T>(val, this.top);
        this.top = newNode;
        if (this.length == 0) {
            this.bottom = newNode;
        }
        this.length++;
    }

    
    public StackNode<T> pop() {
        StackNode<T> returnNode = this.top;
        this.top = this.top.getNext();
        this.length--;
        if (length == 0) {
            this.bottom = null;
        }
        return returnNode;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("HEAD -> ");
        StackNode<T> currentNode = this.top;
        while(currentNode != null) {
            sb.append(String.format("%s -> ", currentNode.toString()));
            currentNode = currentNode.getNext();
        }
        sb.append("<- TAIL");
        return String.format("[%d nodes]: %s ", this.length, sb );
    }

    
}

class StackNode<T> {
    private T val;
    private StackNode<T> next;
    
    public StackNode(T val) {
        this.setVal(val);
        this.setNext(null);
    }
    
    public StackNode(T val, StackNode<T> next) {
        this.setVal(val);
        this.setNext(next);
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
    
    public String toString() {
        return String.format("(%s)", this.getVal().toString());
    }
    
}
