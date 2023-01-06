package org.example;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String args[])
    {
        // Creating empty priority queue
        //PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);
        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.size());

        // Printing the top element again
        System.out.println(pQueue.peek());
    }
}
