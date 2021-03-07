package edu.hamburg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Vertex class
 *
 * @author Yuriel849
 * @version 05.03.2021
 */
@Data
public class Vertex {
    // Name (designation) of this vertex
    private String name;
    // Predecessor vertex on the shortest path from the source to this vertex
    private Vertex pred = null;
    // Distance from the starting vertex
    private int dist;

    public Vertex(String name, int dist) {
        this.name = name;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object object) {
        Vertex other = (Vertex) object;
        if(this.name.equals(other.getName()))
            if(this.dist == other.getDist())
            return true;
        return false;
    }
}
