package com.github.lauraneale.blockingqueue;


public class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();
        Thread consumer = new Thread(new Consumer(queue));
        Thread producer = new Thread(new Producer(queue));
        consumer.start();
        producer.start();
    }
}
