package com.collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(12);
        queue.add(1);
        queue.add(3);
        queue.add(11);



        System.out.println(queue.poll());

        System.out.println(queue.poll());
    }
}
