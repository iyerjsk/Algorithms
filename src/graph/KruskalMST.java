package graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Finding minimal spanning tree with Kruskal Algo using Disjoint set
 * Algorithm:
 * 1. Find all the vertices in the graph and make set using makeSet in Disjoint set
 * 2. Find all the edges in the graph and sort them in asc order of weights
 * 3. For Each edge in sorted list, check if the vertices are part of same set. if not then add them to list and union both of them
 *
 * Space Complexity is O(V + E)
 * Time Complexity is O(eloge + e)
 */
public class KruskalMST {

    public List<Edge<Integer>> getMST(Graph<Integer> graph) {
        Collection<Vertex<Integer>> vertices = graph.getAllVertex();
        DisjointSet ds = new DisjointSet();
        vertices.stream().parallel().forEach(v -> ds.makeSet(v.getId()));
        List<Edge<Integer>> edges = graph.getAllEdges();
        edges.sort(Comparator.comparingInt(Edge::getWeight));
        return edges.stream().filter(edge -> {
            Vertex<Integer> vertex1 = edge.getVertex1();
            Vertex<Integer> vertex2 = edge.getVertex2();

            long val1 = ds.findSet(vertex1.getId());
            long val2 = ds.findSet(vertex2.getId());

            if(val1 != val2) {
                ds.union(val1, val2);
                return true;
            }
            return false;
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 4, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 7, 8);
        KruskalMST mst = new KruskalMST();
        mst.getMST(graph).forEach(edge -> System.out.println(edge.getVertex1() + " " + edge.getVertex2()));
    }
}
