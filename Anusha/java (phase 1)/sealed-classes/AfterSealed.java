// Java 17 - Sealed classes with controlled inheritance
abstract sealed class ShapeSealed permits CircleSealed, RectangleSealed, TriangleSealed {
    public abstract double area();
}

final class CircleSealed extends ShapeSealed {
    private final double radius;
    
    public CircleSealed(double radius) { this.radius = radius; }
    
    @Override
    public double area() { return Math.PI * radius * radius; }
    
    public double getRadius() { return radius; }
}

final class RectangleSealed extends ShapeSealed {
    private final double width, height;
    
    public RectangleSealed(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double area() { return width * height; }
    
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

non-sealed class TriangleSealed extends ShapeSealed {
    private final double base, height;
    
    public TriangleSealed(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double area() { return 0.5 * base * height; }
    
    public double getBase() { return base; }
}

class ShapeProcessor {
    public static String describe(ShapeSealed shape) {
        if (shape instanceof CircleSealed c) {
            return "Circle with radius " + c.getRadius();
        } else if (shape instanceof RectangleSealed r) {
            return "Rectangle " + r.getWidth() + "x" + r.getHeight();
        } else if (shape instanceof TriangleSealed t) {
            return "Triangle with base " + t.getBase();
        }
        return "Unknown shape";
    }
}

public class AfterSealed {
    public static void main(String[] args) {
        System.out.println("=== After Sealed Classes (Java 17) ===");
        
        ShapeSealed circle = new CircleSealed(5.0);
        ShapeSealed rectangle = new RectangleSealed(4.0, 6.0);
        ShapeSealed triangle = new TriangleSealed(3.0, 4.0);
        
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Triangle area: " + triangle.area());
        
        System.out.println("Circle description: " + ShapeProcessor.describe(circle));
        System.out.println("Rectangle description: " + ShapeProcessor.describe(rectangle));
        System.out.println("Only permitted classes can extend ShapeSealed!");
    }
}