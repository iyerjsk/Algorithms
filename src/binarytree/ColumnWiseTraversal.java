package binarytree;

import java.util.*;

public class ColumnWiseTraversal {

    public void  addNodeToHashMap (TreeMap<Integer, List<Integer>> map, Node node, int count) {
        if(node == null) {
            return;
        }
        List<Integer> list = map.get(count);
        if(list == null) list = new ArrayList<>();
        list.add(node.val);
        map.put(count, list);

        addNodeToHashMap(map, node.left, count - 1);
        addNodeToHashMap(map, node.right, count + 1);



    }
    public void printTree (Node node) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Integer::compareTo);
        addNodeToHashMap(map, node, 0);
        Set<Map.Entry<Integer,  List<Integer>>> set = map.entrySet();
        for (Map.Entry<Integer,  List<Integer>> entry: set) {
            List<Integer> values = entry.getValue();
            boolean first = true;
            StringBuilder stringBuilder = new StringBuilder();
            for(Integer integer: values) {
                if(!first) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(integer);
                first = false;
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(3);
        head.left.left = new Node(2);
        head.left.left.right = new Node(4);
        head.right = new Node(7);
        head.right.right = new Node(9);
        head.right.left = new Node(5);

        new ColumnWiseTraversal().printTree(head);
    }
}
