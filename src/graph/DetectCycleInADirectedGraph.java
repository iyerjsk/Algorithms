package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DetectCycleInADirectedGraph<T> {
    public boolean detectCycleInDirectedGraph(Graph<T> graph) {
        Set<Vertex<T>> graySet = new HashSet<>();
        Set<Vertex<T>> blackSet = new HashSet<>();

        Set<Vertex<T>> whiteSet = new HashSet<>(graph.getAllVertex());

        boolean[] result = new boolean[1];
        graph.getAllVertex().forEach(tVertex -> exploreAdjacentVertices(tVertex, whiteSet, graySet, blackSet, result));

        return result[0];
    }

    private void exploreAdjacentVertices(Vertex<T> vertex, Set<Vertex<T>> whiteSet, Set<Vertex<T>> graySet,
                                         Set<Vertex<T>> blackSet, boolean[] result) {
        if(blackSet.contains(vertex) || result[0]) return;

        if(graySet.contains(vertex)) {
            result[0] = true;
            return;
        }

        whiteSet.remove(vertex);
        graySet.add(vertex);

        vertex.getAdjacentVertexes().forEach (v -> exploreAdjacentVertices(v, whiteSet, graySet, blackSet, result));

        blackSet.add(vertex);
        graySet.remove(vertex);
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        DetectCycleInADirectedGraph<Integer> cdg = new DetectCycleInADirectedGraph<>();
        System.out.println(cdg.detectCycleInDirectedGraph(graph));
    }
}
