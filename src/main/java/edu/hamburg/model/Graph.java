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
    private String start = "";
    // Destination
    private String dest = "";
    // Adjacency set to represent the graph.
    private Map<String,Set<Edge>> adj;
    // Is this a weighted graph?
    private boolean weighted = false;

    public Graph(int number, boolean weighted, List<String> names) {
        this.number = number;
        this.weighted = weighted;
        adj = new HashMap<>(number);
        for(int i = 0; i < number; i++) {
            adj.put(names.get(i), new HashSet<Edge>());
        }
    }

    /**
     * Adds a new edge connecting the vertices a and b, with the given weight.
     * @param a
     * @param b
     * @param weight
     */
    public void addEdge(String from, String to, int weight) {
        adj.get(from).add(new Edge(to, weight));
        adj.get(to).add(new Edge(from, weight));
    }
}
