package com.github.lauraneale.blockingqueue;


public class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(5);
        Thread consumer1 = new Thread(new Consumer(queue, 1));
        Thread consumer2 = new Thread(new Consumer(queue, 2));
        Thread producer = new Thread(new Producer(queue, 20));
        consumer1.start();
        consumer2.start();
        producer.start();
    }
}
