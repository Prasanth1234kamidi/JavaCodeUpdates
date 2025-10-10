package privateMethodsinInterface;

public interface Logger {
    default void logInfo(String msg) {
        System.out.println("INFO: " + format(msg));
    }

    default void logError(String msg) {
        System.out.println("ERROR: " + format(msg));
    }

    // private helper, internal use only
    private String format(String msg) {
        return "[" + msg.trim().toUpperCase() + "]";
    }


}
