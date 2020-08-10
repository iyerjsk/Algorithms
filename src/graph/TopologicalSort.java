package graph;

import java.util.*;

public class TopologicalSort<T> {
    public Deque<Vertex<T>> topSort (Graph<T> graph) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        Collection<Vertex<T>> vertices = graph.getAllVertex();
        for (Vertex<T> v: vertices) {
            topSort(v, stack, visited);
        }

        return stack;
    }

    private void topSort(Vertex<T> vertex, Deque<Vertex<T>> stack, Set<Vertex<T>> visited) {
        if(visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);
        vertex.getAdjacentVertexes().forEach(vertex1 -> topSort(vertex1,stack,visited));
        stack.offerFirst(vertex);
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);

        TopologicalSort<Integer> topologicalSort = new TopologicalSort<>();
        Deque<Vertex<Integer>> result = topologicalSort.topSort(graph);
        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }
}
