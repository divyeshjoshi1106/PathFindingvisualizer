package edu.hamburg.model;

import lombok.Data;

import java.util.*;

/**
 * The graph object
 *
 * @author Yuriel849
 * @version 06.03.2021
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
    private Map<Vertex,Set<Edge>> adj;
    // Is this a weighted graph?
    private boolean weighted = false;

    public Graph(int number, boolean weighted, List<String> names) {
        this.number = number;
        this.weighted = weighted;
        adj = new HashMap<>(number);
        for(int i = 0; i < number; i++) {
            adj.put(new Vertex(names.get(i), Integer.MAX_VALUE), new HashSet<Edge>());
        }
    }

    /**
     * Adds a new edge connecting the vertices a and b, with the given weight.
     * @param a
     * @param b
     * @param weight
     */
    public void addEdge(String from, String to, int weight) {
        Vertex start = null, dest = null, temp = null;
        Iterator iterator = adj.keySet().iterator();
        while(iterator.hasNext()) {
            temp = (Vertex) iterator.next();
            if(temp.getName().equals(from)) start = temp;
            else if (temp.getName().equals(to)) dest = temp;
        }

        assert start != null && dest != null;

        adj.get(start).add(new Edge(to, weight));
        adj.get(dest).add(new Edge(from, weight));
    }
}
