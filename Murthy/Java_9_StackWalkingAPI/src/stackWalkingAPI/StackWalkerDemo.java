package stackWalkingAPI;

public class StackWalkerDemo {

	public static void main(String[] args) {
		System.out.println("=== StackWalker Demo (Java 9+) ===");
        firstMethod();
    }

    static void firstMethod() {
        secondMethod();
    }

    static void secondMethod() {
        thirdMethod();
    }

    static void thirdMethod() {
        // Create StackWalker instance with RETAIN_CLASS_REFERENCE (optional)
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

        System.out.println("\n--- Full Stack Trace (Using StackWalker) ---");
        walker.forEach(frame -> System.out.println(frame));

        // Get the immediate caller
        String callerMethod = walker.walk(frames ->
                frames.skip(1)              // Skip current frame (thirdMethod)
                      .findFirst()          // Get next frame (the caller)
                      .map(StackWalker.StackFrame::getMethodName)
                      .orElse("Unknown"));

        System.out.println("\nImmediate Caller Method: " + callerMethod);

        // Example of filtering
        System.out.println("\n--- Filtered Frames (only classes containing 'StackWalkerDemo') ---");
        walker.walk(frames -> {
            frames.filter(f -> f.getClassName().contains("StackWalkerDemo"))
                  .forEach(System.out::println);
            return null; // important to avoid type inference error
        });

	}

}
