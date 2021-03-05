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
@AllArgsConstructor
public class Vertex {
    // Name (designation) of this vertex
    private String name;
    // Distance from the starting vertex
    private int dist;
}
