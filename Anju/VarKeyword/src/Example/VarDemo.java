package Example;

import java.util.HashMap;
import java.util.List;

public class VarDemo 
{
	public static void main(String[] args) {
        var name = "Anju";      // String
        var age = 25;           // int
        var scores = List.of(90, 85, 88); // List<Integer>

        System.out.println(name + " is " + age + " years old.");
        
        for (var score : scores) {
            System.out.println("Score: " + score);
        }

        var map = new HashMap<String, Integer>();
        map.put("Java", 10);
        map.put("Python", 20);

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
