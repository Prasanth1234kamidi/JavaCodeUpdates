package record;

public class OldStyleRecord {
	 record Point(int x, int y) {}
	         
    public static void main(String[] args) {
      
        Object obj = new Point(5, 10);

        if (obj instanceof Point) {
            Point p = (Point) obj;   
            int x = p.x();           
            int y = p.y();
            System.out.println("Coordinates: " + x + ", " + y);
            
        } else {
            System.out.println("Not a Point object");
        }
    }

}
