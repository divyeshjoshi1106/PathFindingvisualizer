package edu.hamburg.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The graph object
 *
 * @author Yuriel849
 * @version 02.03.2021
 */
public class Graph {
    // Number of vertices
    private int number;
    // Starting point
    private int start;
    // Destination
    private int dest;
    // Adjacency set to represent the graph.
    private List<Set<Integer>> adj;

    public Graph(int number) {
        this.number = number;
        adj = new ArrayList<Set<Integer>>(number);
        for(int i = 0; i < number; i++) {
            adj.add(new HashSet<>());
        }
    }

    public void addVertex(int )
}
