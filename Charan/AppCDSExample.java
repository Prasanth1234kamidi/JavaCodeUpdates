public class AppCDSExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Application started...");
        for (int i = 0; i < 5; i++) {
            System.out.println("Processing step " + (i + 1));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Completed in " + (end - start) + " ms");
    }
}
