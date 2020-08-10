package graph;

import java.util.*;

/**
 * Detecting cycle in an undirected graph.
 * There are 2 ways
 * 1. Using DisjointSet
 * 2. DFS using visitedSet (Set of vertex that are visited)
 */
public class CycleInUndirectedGraph {
    public boolean detectCycleUsingDisjointSet(Graph<Integer> graph) {

        Collection<Vertex<Integer>> vertices = graph.getAllVertex();
        DisjointSet ds = new DisjointSet();
        vertices.forEach(vertex -> ds.makeSet(vertex.getId()));

        final boolean[] result = new boolean[1];

        graph.getAllEdges().forEach(edge -> {
            Vertex<Integer> vertex1  = edge.getVertex1();
            Vertex<Integer> vertex2 = edge.getVertex2();

            if(ds.findSet(vertex1.getId()) == ds.findSet(vertex2.getId())) {
                result[0] = true;
            } else {
                ds.union(vertex1.getId(), vertex2.getId());
            }
        });

        return result[0];
    }

    public boolean detectCycleUsingDFS(Graph<Integer> graph) {
        Set<Vertex<Integer>> visitedSet = new HashSet<>();
        boolean[] result = new boolean[1];
        Optional<Vertex<Integer>> vertex = graph.getAllVertex().stream().findFirst();
        vertex.ifPresent(integerVertex -> exploreAdjacentVertices(integerVertex, null, visitedSet, result));
        return result[0];
    }

    private void exploreAdjacentVertices(Vertex<Integer> current, Vertex<Integer> parent,
                                            Set<Vertex<Integer>> visitedSet, boolean[] result) {
        visitedSet.add(current);
        for(Vertex<Integer> v: current.getAdjacentVertexes()) {
            if(!v.equals(parent)) {
                if (visitedSet.contains(v)) {
                    result[0] = true;
                } else {
                    exploreAdjacentVertices(v, current, visitedSet, result);
                }
            }
            if(result[0]) {
                return;
            }
        }
    }

    public static void main(String args[]){

        CycleInUndirectedGraph cycle = new CycleInUndirectedGraph();
        Graph<Integer> graph = new Graph<Integer>(false);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        boolean isCycle = cycle.detectCycleUsingDisjointSet(graph);
        System.out.println(isCycle);
        isCycle = cycle.detectCycleUsingDFS(graph);
        System.out.print(isCycle);

    }
}
