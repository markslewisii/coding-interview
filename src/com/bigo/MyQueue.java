package com.bigo;

public class MyQueue<T> {
    
    public static void main(String[] args) {

        MyQueue<Integer> stack = new MyQueue<>(5);
        
        //System.out.println(stack.peek());
        stack.enqueue(10);
        stack.enqueue(15);
        System.out.println(stack);
        System.out.println(stack.dequeue());
        System.out.println(stack);

    }

    public QueueNode<T> first;
    public QueueNode<T> last;
    public int length = 0;
    
    public MyQueue(T val) {
        this.enqueue(val);
        // this.top = new StackNode<T>(val);
        // this.bottom = this.top;
    }
    
    
    public T peek() {
        if (this.length == 0) {
            return null;
        }
        return this.first.getVal();
    }

    
    public void enqueue(T val) {
        QueueNode<T> newNode = new QueueNode<T>(val);
        if (this.length > 0) {
            this.last.setNext(newNode);
        } else {
            this.first = newNode;
        }
        this.last = newNode;
        this.length++;
    }
    
    public QueueNode<T> dequeue() {
        QueueNode<T> returnNode = this.first;
        this.first = this.first.getNext();
        this.length--;
        if (length == 0) {
            this.last = null;
        }
        return returnNode;
    }
    
    public Boolean isEmpty() {
        return this.length == 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("FIRST -> ");
        QueueNode<T> currentNode = this.first;
        while(currentNode != null) {
            sb.append(String.format("%s -> ", currentNode.toString()));
            currentNode = currentNode.getNext();
        }
        sb.append("<- LAST");
        return String.format("[%d nodes]: %s ", this.length, sb );
    }

    
}

class QueueNode<T> {
    private T val;
    private QueueNode<T> next;
    
    public QueueNode(T val) {
        this.setVal(val);
        this.setNext(null);
    }
    
    public QueueNode(T val, QueueNode<T> next) {
        this.setVal(val);
        this.setNext(next);
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
    
    public String toString() {
        return String.format("(%s)", this.getVal().toString());
    }
    
}
