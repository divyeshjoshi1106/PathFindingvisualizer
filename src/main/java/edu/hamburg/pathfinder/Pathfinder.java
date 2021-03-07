package edu.hamburg.pathfinder;

import edu.hamburg.model.Graph;
import edu.hamburg.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Pathfinder interface
 * to be implemented by the pathfinder classes implementing
 * the graph pathfinding algorithms, such as the Depth-First Search or Dijkstra's algorithm.
 *
 * @author Yuriel849
 * @version 06.03.2021
 */
public interface Pathfinder {
    public List findPath(int number, int maxWeight, boolean weighted, String[] names, String start, String dest);

    /**
     * Finds the next step in the pathfinding process.
     * Returns information on the next step to take, to pass on to the GUI.
     */
    // public Set findNextStep() {}
}
