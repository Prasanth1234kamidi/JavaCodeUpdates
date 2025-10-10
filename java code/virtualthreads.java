public class virtualthreads{

    public static void main(String[] args) throws InterruptedException {
        int taskCount = 1000000;
          System.out.println("\n=== Virtual Threads ===");
        virtualThreads(taskCount);

        System.out.println("=== Traditional Threads ===");
        traditionalThreads(taskCount);

      
    }

    // 🔹 Traditional Threads
    public static void traditionalThreads(int taskCount) throws InterruptedException {
        Thread[] threads = new Thread[taskCount];

        for (int i = 0; i < taskCount; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1000); // Simulate I/O
                    // Uncomment below to see thread names
                    // System.out.println("Task done by: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("All tasks finished (Traditional Threads)");
    }

    // 🔹 Virtual Threads (Java 21+)
    public static void virtualThreads(int taskCount) throws InterruptedException {
        Thread[] threads = new Thread[taskCount];

        for (int i = 0; i < taskCount; i++) {
            threads[i] = Thread.ofVirtual().start(() -> {
                try {
                    Thread.sleep(1000); // Simulate I/O
                    // Uncomment below to see thread names
                    // System.out.println("Task done by: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("All tasks finished (Virtual Threads)");
    }
}
