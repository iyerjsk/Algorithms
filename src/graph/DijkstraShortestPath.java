package graph;

import java.util.HashMap;
import java.util.Map;

public class DijkstraShortestPath {

    public Map<Vertex<Integer>,Integer> getShortestPathFromSource(Graph<Integer> graph, Vertex<Integer> source) {

        Map<Vertex<Integer>, Vertex<Integer>> vertexToParent = new HashMap<>();
        Map<Vertex<Integer>, Integer> distanceMap = new HashMap<>();
        BinaryMinHeap<Vertex<Integer>> heap = new BinaryMinHeap<>();

        graph.getAllVertex().forEach (vertex -> heap.add(Integer.MAX_VALUE, vertex));

        heap.decrease(source, 0);
        vertexToParent.put(source, null);

        while(!heap.isEmpty()) {
            final Vertex<Integer> current = heap.extractMin().key;
            distanceMap.put(current,  heap.getWeight(current));
            current.getEdges().forEach ( edge -> {
                Vertex<Integer> otherVertex = getOtherVertex(edge, current);
                if(heap.containsData(otherVertex) && heap.getWeight(otherVertex) > (distanceMap.getOrDefault(current, 0) + edge.getWeight())){
                    heap.decrease(otherVertex, (distanceMap.getOrDefault(current, 0) + edge.getWeight()));
                    vertexToParent.put(otherVertex, current);
                }
            });
        }

        return distanceMap;
    }


    private Vertex<Integer> getOtherVertex(Edge<Integer> edge, Vertex<Integer> vertex) {
        return edge.getVertex1().equals(vertex) ? edge.getVertex1(): edge.getVertex2();
    }
}
