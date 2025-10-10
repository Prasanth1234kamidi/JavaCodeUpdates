// Define records for different shapes
record Circle(double radius) {}
record Rectangle(double length, double width) {}
record Triangle(double base, double height) {}

public class RecordDemo {
    public static void main(String[] args) {
        // Array of shape objects (could be any type)

        
        Object[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 7),
            "Not a shape"
        };

        for (Object shape : shapes) {
            // Switch expression with pattern matching
            String result = switch (shape) {
                case Circle c -> "Circle area: " + (Math.PI * c.radius() * c.radius());
                case Rectangle r -> "Rectangle area: " + (r.length() * r.width());
                case Triangle t -> "Triangle area: " + (0.5 * t.base() * t.height());
                default -> "Unknown object type: " + shape;
            };

            System.out.println(result);
        }
    }
}
