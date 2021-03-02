package edu.hamburg.util;

import edu.hamburg.model.Graph;

import java.util.Random;
import java.util.Set;

/**
 * Generates a random graph.
 *
 * @author Yuriel849
 * @version 02.03.2021
 */
public class RandomGenerator {
    /**
     * Generates a random graph with the given number of vertices.
     * The edges are weighted, if so designated.
     * @param number The number of vertices in this graph.
     * @param maxWeight The maximum weight of any edge.
     * @param weighted Boolean designation of whether the edges are weighted or not.
     * @return The generated random graph.
     */
    public static Graph generateRandomGraph(int number, int maxWeight, boolean weighted) {
        Graph graph = new Graph(number, weighted);
        Random random = new Random(System.currentTimeMillis());

        for(int i = 0; i < number * 2; i++) {
            int from, to, weight = 0;
            if(weighted)
                weight = random.nextInt(maxWeight-1) + 1; // To force a minimum weight of 1.
            from = random.nextInt(number);
            while((to = random.nextInt(number)) == from);
            graph.addEdge(from, to, weight);
        }

        return graph;
    }

    public static void main(String[] args) {
        Graph graph = generateRandomGraph(10, 20, true);

        for(Set set : graph.getAdj()) {
            System.out.println(set.toString());
        }
    }
}
