package edu.hamburg.pathfinder;

import edu.hamburg.model.Edge;
import edu.hamburg.model.Graph;
import edu.hamburg.model.Vertex;
import edu.hamburg.util.RandomGenerator;

import java.util.*;

public class Dijkstra implements Pathfinder {
    // The graph object.
    private Graph graph = null;
    // The optimal path from the source to the destination.
    private List<String> path = new LinkedList<>();
    // A min-priority queue.
    private PriorityQueue<Vertex> queue = new PriorityQueue<>(new Comparator<Vertex>() {
        @Override
        public int compare(Vertex v1, Vertex v2) {
            int dist1 = v1.getDist();
            int dist2 = v2.getDist();
            return dist1 < dist2 ? -1 : dist1 == dist2 ? 0 : 1;
        }
    });

    @Override
    public List findPath(
            Graph graph,
            int number,
            String start,
            String dest) {
        Vertex tempVertex = null;
        Edge tempEdge = null;
        int temp = 0;

        //graph = RandomGenerator.generateRandomGraph(number, maxWeight, new ArrayList<>(Arrays.asList(names)));
        graph.setStart(start);
        graph.setDest(dest);

        graph.findVertex(start).setDist(0);
        Iterator keyIterator = graph.getAdj().keySet().iterator();
        while(keyIterator.hasNext()) {
            queue.add((Vertex) keyIterator.next());
        }

        while(!queue.isEmpty()) {
            tempVertex = queue.remove();
            Iterator edgeIterator = graph.getAdj().get(tempVertex).iterator();
            while(edgeIterator.hasNext()) {
                tempEdge = (Edge) edgeIterator.next();
                temp = tempVertex.getDist() + tempEdge.getWeight();
                if(temp < graph.findVertex(tempEdge.getDest()).getDist()) {
                    graph.findVertex(tempEdge.getDest()).setDist(temp);
                    graph.findVertex(tempEdge.getDest()).setPred(tempVertex);
                }
            }
        }
        tempVertex = graph.findVertex(dest);
        while(true) {
            path.add(tempVertex.getName());
            tempVertex = tempVertex.getPred();
            if(tempVertex.equals(graph.findVertex(start)))
                break;
        }

        return path;
    }

    public static void main(String[] args) {
        String[] names = { "A1", "B1", "B2", "D3", "D5", "E10", "E4", "F2", "G1", "H2" };
        Dijkstra dijkstra = new Dijkstra();
        Graph graph = RandomGenerator.generateRandomGraph(10, 20, Arrays.asList(names));
        List path = dijkstra.findPath(graph, 4, "A1", "H2");
        Iterator pathIterator = path.listIterator(path.size());
        while(pathIterator.hasNext())
            System.out.println(pathIterator.next());
    }
}
