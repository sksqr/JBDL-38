package com.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());


        minheap.add(5);
        minheap.add(1);
        minheap.add(10);
        minheap.add(2);

        System.out.println(minheap.poll());
    }
}
