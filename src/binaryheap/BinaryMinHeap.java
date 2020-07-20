package binaryheap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryMinHeap<T extends Comparable<T>> {

    private final List<T> list = new LinkedList<>();

    public T extractMin() {
        T element  = list.isEmpty() ? null : list.get(0);
        list.remove(0);
        heapify(0);
        return element;
    }

    public boolean contains(T key) {
        return list.contains(key);
    }

    private void heapify(int index){
        T current = list.get(index);
        T left = list.get((2 * index) + 1);
        T right = list.get(((2 * index) + 2));
        if(current.compareTo(left) < 0) {
            swap(index, (2 * index) + 1);
            heapify(index);
        }

        if(current.compareTo(left) < 0) {
            swap(index, (2 * index) + 2);
            heapify(index);
        }
    }

    private void swap(int index1, int index2) {
        T element = list.get(index1);
        list.add(index1, list.get(index2));
        list.add(index2, element);
    }
}
