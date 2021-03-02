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
    public static Graph generateRandomGraph(int number, boolean weighted) {
        Graph graph = new Graph(number, weighted);
        Random random = new Random(System.currentTimeMillis());

        for(int i = 0; i < number * 2; i++) {
            int from, to, weight = 0;
            if(weighted)
                weight = random.nextInt(20);
            from = random.nextInt(number);
            while((to = random.nextInt(number)) == from);
            graph.addEdge(from, to, weight);
        }

        return graph;
    }

    public static void main(String[] args) {
        Graph graph = generateRandomGraph(10, true);

        for(Set set : graph.getAdj()) {
            System.out.println(set.toString());
        }
    }
}
