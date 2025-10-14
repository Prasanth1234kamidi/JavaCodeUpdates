package Example;
import jdk.incubator.concurrent.StructuredTaskScope;
import java.util.concurrent.Future;


public class ShutdownOnFailure {
    public static void main(String[] args) throws Exception {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            
            Future<String> profile = scope.fork(() -> fetchProfile());
            Future<String> history = scope.fork(() -> fetchHistory());

            scope.join();           // wait for both
            scope.throwIfFailed();  // if any failed, throw

            System.out.println("Profile: " + profile.resultNow());
            System.out.println("History: " + history.resultNow());
        }
    }

    static String fetchProfile() throws InterruptedException {
        Thread.sleep(1000);
        return "UserProfile";
    }

    static String fetchHistory() throws InterruptedException {
        Thread.sleep(1500);
        return "PurchaseHistory";
    }


}
