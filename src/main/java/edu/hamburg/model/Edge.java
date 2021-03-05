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
    // Name (designation) of the destination vertex of this edge
    private String dest;
    // Weight of this edge
    private int weight;
}
