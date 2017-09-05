package com.github.lauraneale.blockingqueue;

public class Consumer implements Runnable {

    private final BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                int message = queue.poll();
                System.out.println("Consumed message " + message);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e);
        }
    }
}
