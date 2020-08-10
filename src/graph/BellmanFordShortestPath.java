package graph;

import java.util.HashMap;
import java.util.Map;

public class BellmanFordShortestPath {
    public Map<Vertex<Integer>, Integer> getShortestPath(Graph<Integer> graph, Vertex<Integer> source) throws Exception {
        Map<Vertex<Integer>, Vertex<Integer>> vertexToParent = new HashMap<>();
        Map<Vertex<Integer>, Integer> distanceToSource = new HashMap<>();

        graph.getAllVertex().forEach(vertex -> distanceToSource.put(vertex, Integer.MAX_VALUE));

        vertexToParent.put(source, null);
        distanceToSource.put(source, 0);

        int vertexCount = graph.getAllVertex().size();

        for(int i = 0; i < vertexCount - 1 ; i++) {
            graph.getAllEdges().forEach(edge -> {
                Vertex<Integer> vertex1 = edge.getVertex1();
                Vertex<Integer> vertex2 = edge.getVertex2();
                if(distanceToSource.get(vertex1) != Integer.MAX_VALUE &&
                        (distanceToSource.get(vertex1) + edge.getWeight()) < distanceToSource.get(vertex2)) {
                    distanceToSource.put(vertex2, distanceToSource.get(vertex1) + edge.getWeight());
                    vertexToParent.put(vertex2, vertex1);
                }
            });
        }

        graph.getAllEdges().forEach(edge -> {
            Vertex<Integer> vertex1 = edge.getVertex1();
            Vertex<Integer> vertex2 = edge.getVertex2();
            if((distanceToSource.get(vertex1) + edge.getWeight()) < distanceToSource.get(vertex2)) {
                throw new RuntimeException("Negative Cycle found");
            }
        });

        return distanceToSource;
    }

    public static void main(String args[]){

        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(0, 3, 8);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, -3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 3, 1);

        BellmanFordShortestPath shortestPath = new BellmanFordShortestPath();
        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
        Map<Vertex<Integer>,Integer> distance = null;
        try {
            distance = shortestPath.getShortestPath(graph, startVertex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(distance);
    }

}
