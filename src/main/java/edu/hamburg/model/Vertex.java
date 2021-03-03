package edu.hamburg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vertex {
    // Name (designation) of this vertex
    private String name;
    // Distance from the starting vertex
    private int dist;
}
