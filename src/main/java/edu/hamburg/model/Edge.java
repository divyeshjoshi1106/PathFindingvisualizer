package edu.hamburg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * The Edge class
 *
 * @author Yuriel849
 * @version 07.03.2021
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Edge {
    // Name (designation) of the destination vertex of this edge
    @NonNull private String dest;
    private String src;
    // Weight of this edge
    @NonNull private int weight;
}
