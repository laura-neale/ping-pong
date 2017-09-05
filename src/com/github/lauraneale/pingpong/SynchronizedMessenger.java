package com.github.lauraneale.pingpong;

public class SynchronizedMessenger implements Runnable {

    private static final int LOOP_LIMIT = 3;

    private PingPongCoordinator coordinator;
    private String message;

    public SynchronizedMessenger(PingPongCoordinator coordinator, String message) {
        this.coordinator = coordinator;
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < LOOP_LIMIT; i++) {
            try {
                synchronized (coordinator) {
                    System.out.println(message);

                    coordinator.mark();
                    coordinator.notifyAll();

                    boolean currentStatus = coordinator.getStatus();
                    while (coordinator.getStatus() == currentStatus && isNotFinalLoop(i)) {
                        coordinator.wait();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                break;
            }
        }
    }

    private boolean isNotFinalLoop(int i) {
        return i < LOOP_LIMIT - 1;
    }
}
