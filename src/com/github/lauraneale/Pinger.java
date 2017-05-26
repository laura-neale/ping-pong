package com.github.lauraneale;

public class Pinger implements Runnable {

    private static final int LOOP_LIMIT = 10;

    private Coordinator monitor;
    private String message;

    public Pinger(Coordinator monitor, String message) {
        this.monitor = monitor;
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < LOOP_LIMIT; i++) {
            try {
                synchronized (monitor) {
                    System.out.println(message);

                    monitor.flipFlag();
                    monitor.notifyAll();

                    boolean flag = monitor.getPinged();
                    while (monitor.getPinged() == flag) {
                        monitor.wait();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                break;
            }
        }
    }
}
