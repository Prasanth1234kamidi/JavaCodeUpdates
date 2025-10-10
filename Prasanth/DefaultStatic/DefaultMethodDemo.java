package DefaultStatic;

interface Vehicle1 {
    void start(); // abstract method

    default void stop() { // default method
        System.out.println("Vehicle stopped");
    }
}

class Car implements Vehicle1 {
    public void start() {
        System.out.println("Car started");
    }
}

public class DefaultMethodDemo {
    public static void main(String[] args) {
        Vehicle1 car = new Car();
        car.start(); // Car started
        car.stop();  // Vehicle stopped (default method)
    }
}
