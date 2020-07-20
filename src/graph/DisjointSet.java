package graph;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    private static final Map<Long, Node> nodes = new HashMap<>();

    public static class Node {
        int rank;
        long value;
        Node parent;
    }

    public void makeSet(long val) {
        Node node = new Node();
        node.value = val;
        node.parent = node;
        nodes.put(val, node);
    }

    public void union (long val1, long val2){
        Node node1 = nodes.get(val1);
        Node node2 = nodes.get(val2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if(parent1 == parent2)
            return; // if parent1 and parent2 are same then they are both in the same set

        if(parent1.rank >= parent2.rank) {
            parent1.rank = parent1.rank == parent2.rank ? ++parent1.rank : parent1.rank;

            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
    }

    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(parent);
        return node.parent;
    }

    public long findSet(long val) {
        return findSet(nodes.get(val)).value;
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
}
