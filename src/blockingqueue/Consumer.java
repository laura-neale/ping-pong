package blockingqueue;

public class Consumer implements Runnable {

    private final BlockingQueue queue;
    private final int id;

    public Consumer(BlockingQueue queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    public void run() {
        try {
            while (true) {
                int message = queue.poll();
                System.out.println("C-" + id + " consumed message " + message);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e);
        }
    }
}
