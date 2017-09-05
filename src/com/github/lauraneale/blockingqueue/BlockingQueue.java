package com.github.lauraneale.blockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BlockingQueue {

    private final int size = 5;
    private final List<Integer> queue;

    public BlockingQueue() {
        queue = new ArrayList<>();
    }

    public synchronized void add(int s) throws InterruptedException {
        while (queue.size() == size) {
            wait();
        }
        queue.add(s);
        notifyAll();
    }

    public synchronized int poll() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int message = queue.get(0);
        queue.remove(0);
        notifyAll();
        return message;
    }
}
