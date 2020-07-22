package graph;

import java.util.*;

public class BinaryMinHeap {

    private final List<Edge> list = new LinkedList<>();
    private final HashMap<String, Integer> map = new HashMap<>();

    public T extractMin() {
        T element  = list.isEmpty() ? null : list.get(0);
        list.remove(0);
        heapify(0);
        return element;
    }

    public boolean contains(T key) {
        return map.containsKey(key);
    }

    private void heapify(int index){
        if(index >= list.size())
            return;
        int smallestIndex = index;
        int leftIndex = (2 * index) + 1;
        int rightIndex = (2 * index) + 1;
        T current = list.get(index);
        if(leftIndex < list.size() && current.compareTo(list.get(leftIndex)) < 0) {
            smallestIndex = leftIndex;
        }

        if(rightIndex < list.size() && current.compareTo(list.get(rightIndex)) < 0) {
            smallestIndex = rightIndex;
        }
        if(smallestIndex != index) {
            swap(smallestIndex, index);
            heapify(smallestIndex);
        }

    }

    public void decreaseKey(T element, )

    private void swap(int index1, int index2) {
        T element = list.get(index1);
        list.add(index1, list.get(index2));
        list.add(index2, element);
    }
}
