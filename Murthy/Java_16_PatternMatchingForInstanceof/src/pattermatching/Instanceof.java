package pattermatching;

public class Instanceof {
	
	public static void main(String[] args) {
		Object obj = "Hello Everyone";
       if (obj instanceof String s) { 
            
            System.out.println("Original string: " + s);
            System.out.println("Uppercase string: " + s.toUpperCase());
        } 
      else {
            System.out.println("Object is not a String.");
        }

        Object obj2 = 123;

        if (obj2 instanceof String s2) {
            System.out.println("This won't print.");
        } 
      else {
            System.out.println("obj2 is not a String."); 
        }
	  }
    }
