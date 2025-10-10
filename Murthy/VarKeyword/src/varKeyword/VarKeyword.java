package varKeyword;

import java.util.List;

public class VarKeyword {

	public static void main(String[] args) {
		var names = List.of("Sai", "Ravi", "Kiran", "Akash");

            for (var name : names) {
            
            	System.out.println(name);
        }

	}

}
