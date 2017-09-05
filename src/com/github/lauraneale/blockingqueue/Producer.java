package com.github.lauraneale.blockingqueue;

public class Producer implements Runnable {

    private final BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 0; i < 30; i++) {
                System.out.println("Produced message " + i);
                queue.add(i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e);
        }
    }
}
