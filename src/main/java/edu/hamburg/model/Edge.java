package edu.hamburg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    // Destination vertex of this edge
    private int dest;
    // Weight of this edge
    private int weight;
}
