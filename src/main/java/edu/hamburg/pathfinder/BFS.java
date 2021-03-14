package edu.hamburg.pathfinder;

import edu.hamburg.model.Edge;
import edu.hamburg.model.Graph;
import edu.hamburg.model.Vertex;
import edu.hamburg.util.RandomGenerator;

import java.util.*;

public class BFS implements Pathfinder {
    @Override
    public List findPath(Graph graph, int number, String start, String dest) {
        ArrayList<String> indices = new ArrayList<>(number);
        int[] pred = new int[number]; // Index 'i' of pred stores predecessor of i
        int[] dist = new int[number]; // Index 'i' of dist stores distance of i from start

        for(Vertex vertex : graph.getAdj().keySet()) { // Initialize indices
            indices.add(vertex.getName());
        }
        int src = indices.indexOf(start);
        int end = indices.indexOf(dest);

        if (!BFS(graph, src, end, number, indices, pred, dist)) { // Initialize pred and dist
            System.out.println("Given source and destination are not connected");
            return null;
        }

        // LinkedList to store path
        LinkedList<Integer> path = new LinkedList<>();
        int crawl = end;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        // Print distance
        System.out.println("Shortest path length is: " + dist[end]);

        // Print path
        System.out.println("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }

        return null;
    }

    // a modified version of BFS that stores predecessor
    // of each vertex in array pred
    // and its distance from source in array dist
    private static boolean BFS(Graph graph, int src, int end, int number,
        List indices, int[] pred, int[] dist) {
        Edge edge = null;
        Vertex vertex = null;

        // a queue to maintain queue of vertices whose
        // adjacency list is to be scanned as per normal
        // BFS algorithm using LinkedList of Integer type
        LinkedList<Integer> queue = new LinkedList<>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean[] visited = new boolean[number];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < number; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            String name = (String) indices.get(u);
            Iterator iterator = graph.getAdj().get(graph.findVertex(name)).iterator();
            while(iterator.hasNext()) {
                edge = (Edge) iterator.next();
                int tempDest = indices.indexOf(edge.getDest());
                if (!visited[tempDest]) {
                    visited[tempDest] = true;
                    dist[tempDest] = dist[u] + 1;
                    pred[tempDest] = u;
                    queue.add(tempDest);

                    // stopping condition (when we find
                    // our destination)
                    if (tempDest == end)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] names = { "A1", "B1", "C4", "B2", "D3", "D5", "E10", "E4", "F2", "G1", "H2", "I9", "L3", "J6", "U8", "P0", "R3", "E12", "X20", "Z1" };
        BFS bfs = new BFS();
        Graph graph = RandomGenerator.generateRandomGraph(20, 0, Arrays.asList(names));
        List path = bfs.findPath(graph, 20, "A1", "H2");
    }
}
