package edu.hamburg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Edge class
 *
 * @author Yuriel849
 * @version 05.03.2021
 */
@Data
@AllArgsConstructor
public class Edge {
<<<<<<< HEAD
    // Destination vertex & source of this edge
    private String dest,src;
=======
    // Name (designation) of the destination vertex of this edge
    private String dest;
>>>>>>> ec9dd9774e88c3ef9e6dea94cd0c3135e4d4132d
    // Weight of this edge
    private int weight;

    Edge(String dest, String src, int weight)
    {
        this.dest = dest;
        this.src = src;
        this.weight = weight;
    }
}
