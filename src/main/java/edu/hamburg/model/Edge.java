package edu.hamburg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    // Destination vertex & source of this edge
    private String dest,src;
    // Weight of this edge
    private int weight;

    Edge(String dest, String src, int weight)
    {
        this.dest = dest;
        this.src = src;
        this.weight = weight;
    }
}
