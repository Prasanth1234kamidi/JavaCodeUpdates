package recordPattern;

public class RecordPattern {
    record Point(int x, int y) {}

    public static void main(String[] args) {
        	
        
        Object obj = new Point(5, 10);

        
        if (obj instanceof Point(int x, int y)) 
        {
            System.out.println("Coordinates: " + x + ", " + y);
        } 
        
        else {
            System.out.println("Not a Point object");
        }
     }
  } 


