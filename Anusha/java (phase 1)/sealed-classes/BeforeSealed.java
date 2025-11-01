// Before Java 17 - No control over inheritance
abstract class ShapeBefore {
    public abstract double area();
}

class CircleBefore extends ShapeBefore {
    private final double radius;
    
    public CircleBefore(double radius) { this.radius = radius; }
    
    @Override
    public double area() { return Math.PI * radius * radius; }
}

class RectangleBefore extends ShapeBefore {
    private final double width, height;
    
    public RectangleBefore(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double area() { return width * height; }
}

// Problem: Anyone can extend Shape
class UnexpectedShape extends ShapeBefore {
    @Override
    public double area() { return 0; } // Breaks our assumptions
}

public class BeforeSealed {
    public static void main(String[] args) {
        System.out.println("=== Before Sealed Classes ===");
        
        ShapeBefore circle = new CircleBefore(5.0);
        ShapeBefore rectangle = new RectangleBefore(4.0, 6.0);
        ShapeBefore unexpected = new UnexpectedShape();
        
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Unexpected shape area: " + unexpected.area());
        System.out.println("Problem: Anyone can extend ShapeBefore!");
    }
}