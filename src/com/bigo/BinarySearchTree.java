package com.bigo;


import java.util.ArrayList;

import org.json.JSONObject;


public class BinarySearchTree<T extends Comparable<T>> {

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        
        /*
         9
     4         20
  1      6  15    170
         */
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        /*
        System.out.println(bst);
        System.out.println(bst.lookup(170));
        
        System.out.println(bst.breadthFirstSearch());
                */

        System.out.println(bst.breadthFirstSearchRecursive());
        
        System.out.println(bst.inOrder());
        System.out.println(bst.preOrder());
        System.out.println(bst.postOrder());
        System.out.println(bst.validate());
        bst.root.getRight().getRight().setRight(new Node<Integer>(-1));
        System.out.println(bst.validate());
    }
    
    private static int IS_LESS_THAN = -1;
    private static int IS_GREATER_THAN = 1;
    private static int IS_EQUAL_TO = 0;

    public Node<T> root = null;
    public BinarySearchTree() {
        //this.insert(val);
        // this.top = new StackNode<T>(val);
        // this.bottom = this.top;
    }

    public void insert(T val) {
        this.insert(this.root, new Node<T>(val));
    }

    public void insert(Node<T> thisNode, Node<T> insertNode) {
        if (this.root == null) {
            this.root = insertNode;
        } else if (thisNode.compareTo(insertNode) == IS_GREATER_THAN) {
            if (thisNode.getLeft() == null) {
                thisNode.setLeft(insertNode);
            } else {
                insert(thisNode.getLeft(), insertNode);
            }
        } else {
            if (thisNode.getRight() == null) {
                thisNode.setRight(insertNode);
            } else {
                insert(thisNode.getRight(), insertNode);
            }
        }

    }
    
    public Node<T> lookup(T val) {
        return this.lookup(this.root, val);
    }
    
    private Node<T> lookup(Node<T> node, T val) {
        if (this.root == null) {
            return null;
        }
        if (node.getVal().compareTo(val) == IS_EQUAL_TO) {
            return node;
        } else if (node.getVal().compareTo(val) == IS_GREATER_THAN) {
            return lookup(node.getLeft(), val);
        } else {
            return lookup(node.getRight(), val);
        }
    }
    
    
    public ArrayList<T> breadthFirstSearch() {
        ArrayList<T> list = new ArrayList<>();
        ArrayList<Node<T>> queue = new ArrayList<>();
        Node<T> thisNode;
        queue.add(this.root);
        while (queue.size() > 0) {
            thisNode = queue.remove(0);
            if (thisNode.getLeft() != null) queue.add(thisNode.getLeft()); 
            if (thisNode.getRight() != null) queue.add(thisNode.getRight());
            list.add(thisNode.getVal());
        }
        return list;
    }
    
    public ArrayList<T> breadthFirstSearchRecursive() {
        ArrayList<Node<T>> queue = new ArrayList<>();
        queue.add(this.root);
        return breadthFirstSearchRecursive(queue, new ArrayList<T>());
    }
    
    private ArrayList<T> breadthFirstSearchRecursive(ArrayList<Node<T>> queue, ArrayList<T> list) {
        if (queue.size() == 0) {
            return list;
        } else {
            Node<T> thisNode = queue.remove(0);
            if (thisNode.getLeft() != null) {
                queue.add(thisNode.getLeft()); 
            }
            if (thisNode.getRight() != null) {
                queue.add(thisNode.getRight());
            }
            list.add(thisNode.getVal());
            return breadthFirstSearchRecursive(queue, list);
        }
    }
    
    
    public ArrayList<T> inOrder() {
        return inOrder(new ArrayList<T>(), this.root);
    }
    
    public ArrayList<T> preOrder() {
        return preOrder(new ArrayList<T>(), this.root);
    }
    
    public ArrayList<T> postOrder() {
        return postOrder(new ArrayList<T>(), this.root);
    }
    
    private ArrayList<T> inOrder(ArrayList<T> list, Node<T> node) {
        if (node.getLeft() != null) {
            inOrder(list, node.getLeft());
        }
        list.add(node.getVal());
        if (node.getRight() != null) {
            inOrder(list, node.getRight());
        }
        return list;
    }
    
    private ArrayList<T> preOrder(ArrayList<T> list, Node<T> node) {
        list.add(node.getVal());
        if (node.getLeft() != null) {
            preOrder(list, node.getLeft());
        }
        if (node.getRight() != null) {
            preOrder(list, node.getRight());
        }
        return list;
    }
    
    private ArrayList<T> postOrder(ArrayList<T> list, Node<T> node) {
        if (node.getLeft() != null) {
            postOrder(list, node.getLeft());
        }
        if (node.getRight() != null) {
            postOrder(list, node.getRight());
        }
        list.add(node.getVal());
        return list;
    }
    
    
    public Boolean validate() {
        return validate(this.root);
    }
    
    private Boolean validate(Node<T> node) {
        
        if (node.getLeft() != null && node.getRight() != null) {
            return (node.getVal().compareTo(node.getLeft().getVal()) >= 0 && 
                    node.getVal().compareTo(node.getRight().getVal()) <= 0 &&
                    this.validate(node.getLeft()) &&
                    this.validate(node.getRight()));
        } else if (node.getLeft() == null && node.getRight() != null) {
            return (node.getVal().compareTo(node.getRight().getVal()) <= 0 &&
                    this.validate(node.getRight()));
        } else if (node.getLeft() != null && node.getRight() == null) {
            return (node.getVal().compareTo(node.getLeft().getVal()) >= 0 && 
                    this.validate(node.getLeft()));
        } else {
            return true;
        }
    }
    
    
    public String toString() {
        if (this.root == null) {
            return  "null";
        } else {
            JSONObject json = new JSONObject(this.root.toString()); // Convert text to object
            return json.toString(4); // Print it with specified indentation
        }
    }

}

class Node<T extends Comparable<T>> {
    private T       val;
    private Node<T> left;
    private Node<T> right;

    public Node(T val) {
        this.setVal(val);
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public int compareTo(Node<T> n) {
        return this.getVal().compareTo(n.getVal());
    }
    
//    public JSONObject toJsonObject() {
//        JSONObject jsonObj = new JSONObject();
//        jsonObj.put("val", this.getVal());
//        jsonObj.put("left", Optional.ofNullable(this.getLeft().getVal().toString()).orElse("null"));
//        jsonObj.put("right", Optional.ofNullable(this.getRight().getVal().toString()).orElse("null"));
//        return jsonObj;
//    }

    public String toString() {
        String leftStr = (this.getLeft() == null) ? "null" : this.getLeft().toString();
        String rightStr = (this.getRight() == null) ? "null" : this.getRight().toString();
//        String leftStr = "left";
//        String rightStr = "right";
        return String.format("{\"val\" : \"%s\", \"left\" : %s, \"right\" : %s}", this.getVal().toString(), leftStr, rightStr);
    }
}
