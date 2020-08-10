package graph;

import java.util.*;

public class PrimMST {

    public List<Edge<Integer>> getPrimMST(Graph<Integer> graph) {
        Collection<Vertex<Integer>> vertexes = graph.getAllVertex();
        Map<Vertex<Integer>, Edge<Integer>> vertexEdgeMap = new HashMap<>();
        BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
        List<Edge<Integer>> result = new ArrayList<>();

        vertexes.forEach(vertex -> minHeap.add(Integer.MAX_VALUE, vertex));

        Iterator<Vertex<Integer>> iterator = vertexes.iterator();
        if(iterator.hasNext()) {
            minHeap.decrease(iterator.next(), 0);
        }

        while(!minHeap.isEmpty()) {
            Vertex<Integer> current = minHeap.extractMin().key;
            Edge<Integer> minimalEdge = vertexEdgeMap.get(current);
            if(minimalEdge != null) {
                result.add(minimalEdge);
            }
            List<Edge<Integer>> adjacentEdgesForCurrentVertex = current.getEdges();
            final Vertex<Integer> vertex1 = current;
            adjacentEdgesForCurrentVertex.forEach(edge -> {
                Vertex<Integer> otherVertex = getOtherVertex(edge, vertex1);
                if(minHeap.containsData(otherVertex) && edge.getWeight() < minHeap.getWeight(otherVertex)) {
                    minHeap.decrease(otherVertex, edge.getWeight());
                    vertexEdgeMap.put(otherVertex, edge);
                }
            });
        }
        return  result;

    }

    private Vertex<Integer> getOtherVertex (Edge<Integer> edge, Vertex<Integer> vertex) {
        return edge.getVertex1().equals(vertex) ? edge.getVertex2() : edge.getVertex1();
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(false);
     /* graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(2, 5, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 7);*/

        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

        PrimMST prims = new PrimMST();
        Collection<Edge<Integer>> edges = prims.getPrimMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }
    }

}