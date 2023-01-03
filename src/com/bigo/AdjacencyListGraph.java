package com.bigo;
import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyListGraph {

    public int numNodes = 0;
    public HashMap<Integer, ArrayList<Integer>> adjacentList;
    
    public AdjacencyListGraph() {
        this.adjacentList = new HashMap<Integer,ArrayList<Integer>>();
    }
    
    public void addVertex(Integer vertex) {
        if (this.adjacentList.get(vertex) == null) {
            this.adjacentList.put(vertex, new ArrayList<Integer>());
            this.numNodes++;
        }
    }
    
    public void addEdge(Integer node1, Integer node2) {
        this.addVertex(node1);
        this.addVertex(node2);
        this.adjacentList.get(node1).add(node2);
        this.adjacentList.get(node2).add(node1);
    }

    public static void main(String[] args) {
        AdjacencyListGraph myGraph = new AdjacencyListGraph();
        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);
        myGraph.addEdge(3, 1); 
        myGraph.addEdge(3, 4); 
        myGraph.addEdge(4, 2); 
        myGraph.addEdge(4, 5); 
        myGraph.addEdge(1, 2); 
        myGraph.addEdge(1, 0); 
        myGraph.addEdge(0, 2); 
        myGraph.addEdge(6, 5);
        System.out.println(myGraph);
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.adjacentList.size(); i++) {
            sb.append(String.format("%d -> %s\n", i, this.adjacentList.get(i)));
        }
        return sb.toString();
    }

}
