package com.bigo;

public class MyDoublyLinkedList {

    public static void main(String[] args) {
        MyDoublyLinkedList mylist = new MyDoublyLinkedList(-1);
        mylist.append(1);
        mylist.append(2);
        mylist.prepend(0);
        mylist.insert(1, 404040);
        mylist.insert(0, 3);
        mylist.insert(0, 4);

       System.out.println(mylist);
        mylist.remove(4);

        System.out.println(mylist);
    }

    private MdllItem head;
    private MdllItem tail;
    private int     length;

    public MyDoublyLinkedList(int val) {
        this.head = new MdllItem(val);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(int val) {
        MdllItem newNode = new MdllItem(val, null, this.tail);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    public void prepend(int val) {
        MdllItem newNode = new MdllItem(val, this.head);
        this.head.setPrev(newNode);
        this.head = newNode;
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
        MdllItem thisNode = this.traverseToIndex(index-1);
        MdllItem newNode = new MdllItem(val, thisNode.getNext(), thisNode);
        thisNode.getNext().setPrev(newNode);
        thisNode.setNext(newNode);
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
        MdllItem thisNode = this.traverseToIndex(index-1);
        MdllItem aboutToDelete = thisNode.getNext();
        aboutToDelete.getNext().setPrev(thisNode);
        thisNode.setNext(aboutToDelete.getNext());
        aboutToDelete.setNext(null);
        aboutToDelete.setPrev(null);
        this.length--; 
    }

    private MdllItem traverseToIndex(int index) {
        MdllItem thisNode = this.head;
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

class MdllItem {

    private int     val;
    private MdllItem next;
    private MdllItem prev;

    public MdllItem(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public MdllItem(int val, MdllItem next) {
        this.val = val;
        this.next = next;
        this.prev = null;
    }

    public MdllItem(int val, MdllItem next, MdllItem prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public MdllItem getNext() {
        return next;
    }

    public void setNext(MdllItem next) {
        this.next = next;
    }

    public String toString() {
        String nextStr = (this.getNext() != null) ? this.getNext().toString() : "null";
        String nextVal = (this.getNext() != null) ? this.getNext().getVal().toString() : "null";
        String prevStr = (this.getPrev() != null) ? this.getPrev().getVal().toString() : "null";
        return String.format("(%s <- (%d) -> %s), %s",
         prevStr,
                this.getVal(),
                nextVal,
                nextStr);
    }

    public MdllItem getPrev() {
        return prev;
    }

    public void setPrev(MdllItem prev) {
        this.prev = prev;
    }

}