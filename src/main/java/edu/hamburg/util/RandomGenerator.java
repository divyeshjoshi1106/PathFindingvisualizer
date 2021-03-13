package edu.hamburg.util;

import edu.hamburg.model.Graph;

import java.util.*;

/**
 * Generates a random graph.
 *
 * @author Yuriel849
 * @version 02.03.2021
 */
public class RandomGenerator {
    static Random random = new Random(System.currentTimeMillis());

    public static Graph generateRandomGraph(int number, int maxWeight) {
        return generateRandomGraph(number, maxWeight, null);
    }

    /**
     * Generates a random graph with the given number of vertices.
     * The edges are weighted, if so designated.
     * @param number The number of vertices in this graph.
     * @param maxWeight The maximum weight of any edge.
     * @return The generated random graph.
     */
    public static Graph generateRandomGraph(int number, int maxWeight, List<String> names) {
        // If the list of vertex names is not provided, autogenerate names for each vertex.
        if(names == null) {
            names = new ArrayList<>(number);
            for(int i = 0; i < number; i++) {
                char letter = (char) ('A' + i);
                int digit = random.nextInt(number - 1) + 1; // To force a minimum value of 1.
                names.add("" + letter + digit);
            }
        }

        Graph graph = new Graph(number, names);

        for(int i = 0; i < number * 2; i++) {
            String from, to;
            int weight = random.nextInt(maxWeight-1) + 1; // To force a minimum weight of 1.
            from = names.get(random.nextInt(number));
            while((to = names.get(random.nextInt(number))).equals(from));
            graph.addEdge(from, to, weight);
        }

        return graph;
    }

    public static void main(String[] args) {
        String[] array = { "A1", "B1", "B2", "D3", "D5", "E10", "E4", "F2", "G1", "H2" };
        ArrayList<String> names = new ArrayList(Arrays.asList(array));
        Graph graph = generateRandomGraph(10, 20);

        Map map = graph.getAdj();
        for(Object key : map.keySet()) {
            System.out.println(key + " : " + map.get(key).toString());
        }
    }
}
