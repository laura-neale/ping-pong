package blockingqueue;

public class Producer implements Runnable {

    private final BlockingQueue queue;
    private final int numberOfMessages;

    public Producer(BlockingQueue queue, int numberOfMessages) {
        this.queue = queue;
        this.numberOfMessages = numberOfMessages;
    }

    public void run() {
        try {
            for (int i = 0; i < numberOfMessages; i++) {
                System.out.println("Produced message " + i);
                queue.add(i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e);
        }
    }
}
