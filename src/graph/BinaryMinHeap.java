package graph;

import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryMinHeap<T> {

    public class Node  {
        int weight;
        T key;
    }
    private final List<Node> allNodes = new LinkedList<>();
    private final HashMap<T, Integer> nodePosition = new HashMap<>();

    public boolean containsData(T key) {
        return nodePosition.containsKey(key);
    }

    public Node extractMin() {
        if(!allNodes.isEmpty()) {
            int size = allNodes.size();

            // Creating node for minimum weight
            Node minNode = new Node();
            minNode.key = allNodes.get(0).key;
            minNode.weight = allNodes.get(0).weight;

            Node lastNode = allNodes.get(size-1);
            allNodes.get(0).key = lastNode.key;
            allNodes.get(0).weight = lastNode.weight;

            nodePosition.remove(minNode.key);
            nodePosition.put(lastNode.key, 0);

            allNodes.remove(size-1);
            size--;

            if(size != 0) {
                int index = 0;
                while(true) {
                    int leftIndex = (2 * index) + 1;
                    int rightIndex = (2 * index) + 2;
                    Node current = allNodes.get(index);
                    int smallestIndex = index;
                    if(leftIndex < size && current.weight < allNodes.get(leftIndex).weight) {
                        smallestIndex = leftIndex;
                    }

                    if(rightIndex < size && current.weight < allNodes.get(leftIndex).weight) {
                        smallestIndex = rightIndex;
                    }
                    if(smallestIndex != index) {
                        swap(smallestIndex, index);
                        updatePositionMap(smallestIndex, index);
                        index = smallestIndex;
                    } else {
                        break;
                    }
                }
            }
            return minNode;
        }
        return null;
    }

    public boolean isEmpty() {
        return allNodes.isEmpty();
    }

    public Integer getWeight(T key) {
        int position = nodePosition.getOrDefault(key, -1);
        return position >= 0 && position < allNodes.size() ?  allNodes.get(position).weight : null;
    }

    private void updatePositionMap(int smallestIndex, int index) {
        nodePosition.put(allNodes.get(smallestIndex).key, smallestIndex);
        nodePosition.put(allNodes.get(index).key, index);
    }

    private void swap(int index1, int index2) {
        Node node1 = allNodes.get(index1);
        Node node2 = allNodes.get(index2);

        T key = node1.key;
        int weight = node1.weight;

        node1.key = node2.key;
        node1.weight = node2.weight;

        node2.key = key;
        node2.weight = weight;
    }

    public void add(int weight, T key) {
        Node newNode = new Node();
        newNode.key = key;
        newNode.weight = weight;

        allNodes.add(newNode);
        nodePosition.put(key, allNodes.size() - 1);

        int index = allNodes.size() - 1;
        while(true) {
            if(index < 1) {
                break;
            }
            int parent = (index - 1)/2;
            if(allNodes.get(parent).weight > allNodes.get(index).weight) {
                swap(parent, index);
                updatePositionMap(parent, index);
                index = parent;
            }else {
                break;
            }
        }
    }

    public void decrease (T key, int newWeight) {
        int position = nodePosition.getOrDefault(key, -1);
        if(position == -1) return;
        allNodes.get(position).weight = newWeight;

        int index = position;
        while(true) {
            if(index < 1) {
                break;
            }
            int parent = (index - 1)/2;
            if(allNodes.get(parent).weight > allNodes.get(index).weight) {
                swap(parent, index);
                updatePositionMap(parent, index);
                index = parent;
            }else {
                break;
            }
        }
    }

    public void printHeap() {
        allNodes.forEach(node -> System.out.println(node.weight + " " + node.key));
    }

    private void printPositionMap() {
        System.out.println(nodePosition);
    }

    public static void main(String args[]){
        BinaryMinHeap<String> heap = new BinaryMinHeap<String>();
        heap.add(3, "Tushar");
        heap.add(4, "Ani");
        heap.add(8, "Vijay");
        heap.add(10, "Pramila");
        heap.add(5, "Roy");
        heap.add(6, "NTF");
        heap.add(2,"AFR");
        System.out.println("--------------------------------------------------------------");
        heap.printHeap();
        heap.printPositionMap();
        heap.decrease("Pramila", 1);
        System.out.println("--------------------------------------------------------------");
        heap.printHeap();
        heap.printPositionMap();
    }
}
