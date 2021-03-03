package edu.hamburg.model;

import lombok.Data;

import java.util.*;

/**
 * The graph object
 *
 * @author Yuriel849
 * @version 02.03.2021
 */
@Data
public class Graph {
    // Number of vertices
    private int number;
    // Starting point
    private int start = 0;
    // Destination
    private int dest = 0;
    // Adjacency set to represent the graph.
    private List<Set<Edge>> adj;
    // Is this a weighted graph?
    private boolean weighted = false;

    public Graph(int number, boolean weighted) {
        this.number = number;
        this.weighted = weighted;
        adj = new ArrayList<Set<Edge>>(number);
        for(int i = 0; i < number; i++) {
            adj.add(new HashSet<Edge>());
        }
    }

    /**
     * Adds a new edge connecting the vertices a and b, with the given weight.
     * @param a
     * @param b
     * @param weight
     */
    public void addEdge(int a, int b, int weight) {
        adj.get(a).add(new Edge(b, weight));
        adj.get(b).add(new Edge(a, weight));
    }
}
