package com.bigo;

import java.util.Optional;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList mylist = new MyLinkedList(-1);
        mylist.append(1);
        mylist.append(2);
        mylist.prepend(0);
        mylist.insert(1, 404040);
        mylist.insert(0, 3);
        mylist.insert(0, 4);

        System.out.println(mylist);
        mylist.remove(4);

        System.out.println(mylist);
        
        mylist.reverse();
        System.out.println(mylist);
    }

    private MllItem head;
    private MllItem tail;
    private int     length;

    public MyLinkedList(int val) {
        this.head = new MllItem(val);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(int val) {
        this.tail.setNext(new MllItem(val));
        this.tail = this.tail.getNext();
        this.length++;
    }

    public void prepend(int val) {
        this.head = new MllItem(val, this.head);
        this.length++;
    }

    public void insert(int index, int val) {
        if (index == 0) {
            this.prepend(val);
            return;
        }
        if (index > length) {
            this.append(val);
            return;
        }
        MllItem thisNode = this.traverseToIndex(index-1);
        thisNode.setNext(new MllItem(val, thisNode.getNext()));
        this.length++;
    }

    public void remove(int index) {
        if (index == 0) {
            this.head = this.head.getNext();
            this.length--;
            return;
        }
        if (index > length-1) {
            index = length-1;
        }
        MllItem thisNode = this.traverseToIndex(index-1);
        MllItem aboutToDelete = thisNode.getNext();
        thisNode.setNext(aboutToDelete.getNext());
        aboutToDelete.setNext(null);
        this.length--; 
    }
    
    // [1,4,2,6,5]
    public void reverse() {
        if (this.length == 1) {
            return;
        }
        
        int i = 0;
        this.tail = this.head;
        MllItem newNext = null;
        MllItem thisNode = this.head; //1
        MllItem thisNext = null;
        while(i++ != this.length) {
            thisNext = thisNode.getNext(); //4
            thisNode.setNext(newNext); //null
            newNext = thisNode; //1
            thisNode = thisNext; //4
        }
        this.head = newNext;
    }

    private MllItem traverseToIndex(int index) {
        MllItem thisNode = this.head;
        int i = 0;
        while (i++ != index) {
            thisNode = thisNode.getNext();
        }
        return thisNode;
    }

    public String toString() {
        return String.format("[%d nodes]: %s", this.length, head.toString());
    }
}

class MllItem {

    private int     val;
    private MllItem next;

    public MllItem(int val) {
        this.val = val;
        this.next = null;
    }

    public MllItem(int val, MllItem next) {
        this.val = val;
        this.next = next;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public MllItem getNext() {
        return next;
    }

    public void setNext(MllItem next) {
        this.next = next;
    }

    public String toString() {
        String nodeStr = (this.getNext() != null) ? this.getNext().toString() : "null";
        return String.format("%d -> %s", this.getVal(), nodeStr);
    }

}