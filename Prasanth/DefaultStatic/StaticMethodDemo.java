package DefaultStatic;
interface Vehicle {
    static void info() {
        System.out.println("Vehicles are for transportation");
    }
}

public class StaticMethodDemo {
    public static void main(String[] args) {
        Vehicle.info(); // call directly from interface
    }
}
